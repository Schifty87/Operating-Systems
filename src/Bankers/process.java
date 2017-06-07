package Bankers;

import java.util.ArrayList;

class process {

	private ArrayList<Integer> hold;
	private ArrayList<Integer> need;
	private int ID;
	
	
	process(ArrayList<Integer> hold, ArrayList<Integer> need, int ID){
		this.hold = hold;
		this.need = need;
		this.ID = ID;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the hold
	 */
	public ArrayList<Integer> getHold() {
		return hold;
	}

	/**
	 * @param hold the hold to set
	 */
	public void setHold(ArrayList<Integer> hold) {
		this.hold = hold;
	}

	/**
	 * @return the need
	 */
	public ArrayList<Integer> getNeed() {
		return need;
	}

	/**
	 * @param need the need to set
	 */
	public void setNeed(ArrayList<Integer> need) {
		this.need = need;
	}
	
	
}
