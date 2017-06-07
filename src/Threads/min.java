package Threads;

import java.util.ArrayList;

class min implements Runnable{
	   
	private ArrayList<Integer> arr;
	private number minValue;
	
	min(ArrayList<Integer> arr, number minValue) {
		this.arr = arr;	 
		this.minValue = minValue;
	}
	   
	public void run() {      
		int min = arr.get(0);
		for(int i = 0; i < arr.size(); i++) {        
			if(arr.get(i) < min){
				min = arr.get(i);
		    }
		}
		minValue.setNumber((int)min);     
	}		
}