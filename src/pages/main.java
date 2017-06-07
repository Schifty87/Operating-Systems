package pages;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		boolean p = false;
		
		System.out.println("How many frames would you like to include?" + "\n" + "Input must be between 1-7: ");
		int frames = s.nextInt();
		
		if(frames < 1 || frames > 7){
			do{
				System.out.print("Page frames must be between 1-7.  Please enter a valid input: ");
				frames = s.nextInt();
				if(frames >= 1 && frames <= 7){
					p = true;
				}
			}while(p == false);
			
		}
		
		System.out.print("What is your page length? ");
		int ref = s.nextInt();
	
		int[] R = new int[ref];
		double num1;
		
		for(int i=0; i< ref; i++){
			num1 = (Math.random()*10);
			R[i] = (int) num1;
		}
		
		//print out random numbers
		for(int i=0; i< R.length; i++){
			System.out.print(R[i] + " ");
		}
		
		faults F = new faults();
		System.out.println("\n");
		System.out.println("FIFO: " + F.FIFO(R, frames));
		System.out.println("LRU: " + F.LRU(R, frames));
		System.out.println("Optimal: " + F.Optimal(R, frames));
		
	}

}
