package Bankers;

import java.util.ArrayList;

class Bankers implements Runnable{
	   
	private process process;
	private Available a;
	
	Bankers(process process, Available a) {
		this.process = process;	 
		this.a = a;
	}
	
	
	static int count = 0;
	
	public void run() { 
		
		//access need and hold ArrayLists for thread
		ArrayList<Integer> need = process.getNeed();
		ArrayList<Integer> hold = process.getHold();
		
		long wait = 0;
		while((need.get(0) > a.getA()) || (need.get(1) > a.getB()) || (need.get(2) > a.getC())){
			//if process is waiting too long, it must not have the resources to run
			//kill the thread
			if(wait == 100000000*2){
				System.out.println("process " + process.getID() + " requesting (" + need.get(0) + "," + need.get(1) + "," + need.get(2) + ") was denied");
				Thread.currentThread().interrupt();
				return;
			}
			//System.out.println(wait);
			wait++;
		}
		
		
		//synchronized class acts as a mutex lock
		synchronized(a){
			
			System.out.println("Process " + process.getID() + " requesting (" + need.get(0) + "," + need.get(1) + "," + need.get(2) +  ") was granted");
			//release resources and add to available
			a.setA((hold.get(0)) + a.getA());
			a.setB((hold.get(1)) + a.getB());
			a.setC((hold.get(2)) + a.getC());
			
			System.out.println("Process " + process.getID() + " exited, leaving (" + a.getA() + "," + a.getB() + "," + a.getC() +  ") resources");
			
			//if the total amount of processes that are created make it through, it is successful!
			count++;
			if(count==a.getTotal()){
				System.out.println("\nSafe State!");
			}
			
		}//end synchronized		
	}//end run()			
}