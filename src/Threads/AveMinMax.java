package Threads;


import java.util.ArrayList;
import java.util.Scanner;


public class AveMinMax {
	public static void main(String args[]) throws InterruptedException{
		//90 81 78 95 79 72 85
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.print("Please input numbers separated by a space: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] sp = input.split(" ");
		for(int i=0; i<sp.length; i++){
			arr.add(Integer.parseInt(sp[i]));		
		}
		
		System.out.println();
		
			number sumObject = new number();	
			Thread A1 = new Thread(new average(arr,sumObject));
			Thread A2 = new Thread(new min(arr, sumObject));
			Thread A3 = new Thread(new max(arr, sumObject));
	
			A1.start();
			A1.join();
			System.out.println("The average value is " + sumObject.getNumber());
			A2.start();
			A2.join();
			System.out.println("The minimum value is " + sumObject.getNumber());
			A3.start();
			A3.join();
			System.out.println("The maximum value is " + sumObject.getNumber());
	}   
}