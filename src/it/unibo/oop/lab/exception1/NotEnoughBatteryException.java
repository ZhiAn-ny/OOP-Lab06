package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot has not enough battery 
 * to complete an action.
 *
 * @implNote Reason behind choice to extend IllegalStateException:
 * Looked at the documentation of the exception types proposed.
 * It can not extend RuntimeException, since that is an unchecked exception
 * and indicates a point of no recovery in the execution of the program.
 * It is also not suitable to extend IllegalStateException, since there are 
 * no invalid inputs parameters. Just bad timing.
 * Therefore it extends Exception.
 * 
 */
public class NotEnoughBatteryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1131254828282511103L;
	private final double batteryLevel;
	
	public NotEnoughBatteryException(final double batteryLevel) {
        super();
        this.batteryLevel = batteryLevel;
    }
	
    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
    	return "Can not complete action. Battery level is " 
    			+ this.batteryLevel + ", not enough";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

}
