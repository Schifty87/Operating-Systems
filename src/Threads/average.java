package Threads;

import java.util.ArrayList;




class average implements Runnable {
	   
	private ArrayList<Integer> arr;
	private number averageValue;
	   
	average(ArrayList<Integer> arr, number averageValue) {
		this.arr = arr;
		this.averageValue = averageValue;
	}
	   
	public void run() {	      	
		int total = 0;
		int average = 0;
		for(int i = 0; i < arr.size(); i++) {
			total = total + arr.get(i);		  
		}
		average = total/arr.size();
		averageValue.setNumber((int)average);
	}	
}
