package Threads;

import java.util.ArrayList;

class max implements Runnable {
	   
	   private ArrayList<Integer> arr;
	   private number maxValue;
	   
	   max(ArrayList<Integer> arr, number maxValue) {
	      this.arr = arr;
	      this.maxValue = maxValue;
	   }
	   
	   public void run() {         
	      int max = arr.get(0);
	      for(int i = 0; i < arr.size(); i++) {        
	    	  if(arr.get(i) > max){
	    		  max = arr.get(i);
	    	  }
	      }
	      maxValue.setNumber((int)max);      
	   }	   
}
