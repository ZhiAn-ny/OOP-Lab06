package it.unibo.oop.lab.exception2;

public class TransictionsOverQuotaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1735550047642495366L;
	private final int maximumAllowedATMTransactions;

	public TransictionsOverQuotaException(final int quota) {
		this.maximumAllowedATMTransactions = quota;
	}
	
	public String toString() {
		return "Can not complete operation: reached atm transictions quota, "
				+ "only " + this.maximumAllowedATMTransactions 
				+ " transictions are allowed";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
