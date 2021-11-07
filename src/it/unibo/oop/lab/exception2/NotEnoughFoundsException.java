package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;

	public NotEnoughFoundsException() {
		
	}
	
	public String toString() {
		return "Can not complete operation: non-sufficient funds";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
