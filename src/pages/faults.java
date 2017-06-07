package pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class faults {
	faults(){}
	
	public int FIFO(int page[], int frame){
		int faults = 0;
		int[] frames = new int[frame];		
		
		//initialize the layers of frames
		for(int i=0; i< frame; i++){
			frames[i] = 11;
		}
		
		int count = 0;
		
		//go through random values
		for(int i=0; i<page.length; i++){
			int found = 0;
			for(int j=0; j<frames.length; j++){
				if(page[i]==frames[j]){
					found = 1;
				}
			}
			if(found==0){
				faults++;
				if(count > (frame-1)){
					//reset value of count
					count = 0;
				}
				if(frames[count]==11){
					frames[count] = page[i];					
				}
				else{
					frames[count] = page[i];							
				}
				count++;
			}
		}
		return faults;
	}	


	
	public int LRU(int page[], int frame){
		int[] frames = new int[frame];
		
		int faults = 0;
		for(int i=0; i<frame; i++){
			frames[i]=11;
			
		}
		int found;
		//go through list
		for(int i= 0; i<page.length; i++){
			found = 0;
			//System.out.print(R[i] + " ");
			
			int H = 0;
			
			do{
				
				if(frames[H]==page[i]){
					found++;
					break;
				}
				if(frames[H]==11){
					frames[H] = page[i];
					faults++;
					found++;
					break;				
				}
				H++;
			}while(H < frame);
			
			if(found==0){
		
				faults++;
				//initialize array to keep track of distances from page fault
				ArrayList<Integer> min = new ArrayList<Integer>();
							
				/*iterate through list backwards
				 *determine which number was used 
				 *least recently*/
				for(int k=0; k<frame; k++){
					int P = frames[k];
					int count = 0;
					for(int j = i-1; j>-1; j--){
						if(P==page[j]){
							//find the first occurrence of the frame value
							min.add(count);
							break;
						}
						count++;
					}
				}			
				/*find the lowest "min" value
				 *index = frame number*/
				int index = min.indexOf (Collections.max(min));
				frames[index] = page[i];			
			}//end big IF		
		}//end big FOR		
		return faults;						
	}
	

	public int Optimal(int page[], int frame){
		int[] frames = new int[frame];
		
		int faults = 0;
		for(int i=0; i<frame; i++){
			frames[i]=11;
			
		}
		int found;
		//go through list
		for(int i= 0; i<page.length; i++){
			found = 0;
			
			int H = 0;
			
			do{
				
				if(frames[H]==page[i]){
					found++;
					break;
				}
				if(frames[H]==11){
					frames[H] = page[i];
					faults++;
					found++;
					break;			
				}
				H++;				
			}while(H < frame);
			
			if(found==0){		
				faults++;		
				ArrayList<Integer> min = new ArrayList<Integer>();		
				/*iterate through list forwards to
				 *determine which number was used 
				 *least recently*/
				for(int k=0; k<frame; k++){
					int P = frames[k];
					int count = 0;
					int check = 0;
					for(int j = i+1; j<page.length; j++){
						if(P==page[j]){
							check = 1;
							min.add(count);
							break;
						}
						count++;
					}
					if(check==0){
						/*if not found, give it a very large number
						 *will probably be replaced*/
						min.add(100+k);
					}
				}				
				/*find the lowest "min" value
				 *index = frame number*/
				int index = min.indexOf (Collections.max(min));
				frames[index] = page[i];		
			}//end big IF	
		}//end big FOR		
		return faults;		
	}
}
