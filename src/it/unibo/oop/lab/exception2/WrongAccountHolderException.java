package it.unibo.oop.lab.exception2;

/**
 * Represent exception occurred when an account holder tries to execute an 
 * operation on a bank account which is not his own.
 */
public class WrongAccountHolderException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190620326792084901L;
	
	public WrongAccountHolderException() {
		
	}
	
	public String toString() {
		return "Can not complete operation: unauthorized account";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
