package Bankers;

import java.util.ArrayList;
import java.util.Scanner;




public class main {
	
	public static void main(String[] args) throws InterruptedException{
		
		//create ArrayList to fill up during while loop
		ArrayList<process> p = new ArrayList<process>();
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("How much of each resource would you like to start with?");
		
		//create array to hold the initial amount of available resources
		System.out.print("A: ");
		int A = s.nextInt();
		System.out.print("B: ");
		int B = s.nextInt();
		System.out.print("C: ");
		int C = s.nextInt();
		
		//initialize total processes
		int total = 0;
		
		
		/*create new instance of Available with resources that were input 
		 * total starts at 0, but increases as while loop increases*/
		Available a = new Available(A,B,C,total);
		System.out.println("Initial available: " + "a: " + a.getA() + " " + "b: " + a.getB() + " " + "c: " + a.getC());
		
		do{
			int holdA, holdB, holdC, maxA, maxB, maxC, needA, needB, needC;
			
			System.out.println("Would you like to generate a new request?");
			System.out.print(p.size() + "/20 have been created (y/n): ");
			String choice = s.next();
			System.out.println();
			
			//break out of loop if no more requests
			if(choice.equalsIgnoreCase("n")){
				break;
			}
			
			
			//generate max values based on available
			maxA = (int)(Math.random() * a.getA());
			maxB = (int)(Math.random() * a.getB());
			maxC = (int)(Math.random() * a.getC());
			
			/*allocated (hold) cannot be greater than max,
			 * therefore use max to find this random number
			 * This gets rid of the need of another method to 
			 * determine if allocated is greater than available*/
			holdA = (int)(Math.random() * maxA);
			holdB =	(int)(Math.random() * maxB);
			holdC = (int)(Math.random() * maxC);
			
			//add max to ArrayList
			ArrayList<Integer> max = new ArrayList<Integer>();
			max.add(maxA);
			max.add(maxB);
			max.add(maxC);
			
			//add hold to ArrayList
			ArrayList<Integer> hold = new ArrayList<Integer>();
			hold.add(holdA);
			hold.add(holdB);
			hold.add(holdC);
			
			//calculate need, based on max and allocated
			ArrayList<Integer> need = new ArrayList<Integer>();
			for(int i=0; i<max.size(); i++){
				need.add(max.get(i) - hold.get(i));
			}
				
			//subtract allocated (hold) from available
			a.setA(a.getA()-holdA);
			a.setB(a.getB()-holdB);
			a.setC(a.getC()-holdC);
			
			//add new process object to process ArrayList
			p.add(new process(hold,need,total));
			total++;
	
		}while(p.size()<20);
		
		
		//print out the Allocation (hold), Max, and Need table
		System.out.println("                     HOLD                MAX                NEED");
		for(int i=0; i<p.size(); i++){
			ArrayList<Integer> X = p.get(i).getHold();
			ArrayList<Integer> Y = p.get(i).getNeed();
			System.out.printf("%4s %2d %4s %4d %4d %4d %4s %4d %4d %4d %4s %4d %4d %4d \n","process", 
					i, "|", X.get(0),X.get(1),X.get(2), "|", X.get(0)+Y.get(0),X.get(1)+Y.get(1),X.get(2)+Y.get(2), 
					"|", Y.get(0),Y.get(1),Y.get(2));
		}
		
		System.out.println();
		
		//set the total now that everything has been created
		a.setTotal(p.size());
		
		System.out.println("Amount of resources that are available to start: (" + a.getA() + "," + a.getB() + "," + a.getC() + ")\n");
		
		int X = a.getTotal();
		System.out.println(p.size());
		//unleash the threads to run() method within Bankers class
		for(int i= p.size()-1; i>-1; i--){	
			//System.out.println(i);
			Thread A1 = new Thread(new Bankers(p.get(i),a));
			A1.start();		
		}
	}
}
