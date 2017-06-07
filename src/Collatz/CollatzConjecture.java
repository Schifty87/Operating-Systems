package Collatz;

import java.util.ArrayList;

public class CollatzConjecture {
	
	public static void main(String[] args){
		CollatzConjecture CC = new CollatzConjecture();
		CC.conj();
	}//end main
	
		public static void conj(){
			
			int n = 35;	
			while(n !=1){
				if(n%2==0){
					n=n/2;
				}
				else{
					n=(n*3)+1;
				}
				System.out.println(n);				
			}		
		}	
	}	


	
	
	
	

