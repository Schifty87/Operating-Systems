package Bankers;


//this class is used so that every thread can access it
public class Available {
	private int A,B,C, total;
	Available(int A, int B, int C, int total){
		this.A = A;
		this.B = B;
		this.C = C;
		this.total = total;
	}
	/**
	 * @return the a
	 */
	public int getA() {
		return A;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(int a) {
		A = a;
	}
	/**
	 * @return the b
	 */
	public int getB() {
		return B;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(int b) {
		B = b;
	}
	/**
	 * @return the c
	 */
	public int getC() {
		return C;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(int c) {
		C = c;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
}
