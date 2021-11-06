package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot has not enough battery 
 * to complete an action.
 *
 * @implNote Reason behind choice to extend RuntimeException:
 * I went on by exclusion. 
 * Exception alone was too generic, while IllegalStateException didn't 
 * seemed appropriate. In fact, a robot can exist despite having i.e. 0.1
 * battery left and not being able to complete an action. Therefore, it is 
 * a RuntimeException as we were not able to recharge the robot on time.
 * We can still recharge the robot in a second moment.
 * 
 */
public class NotEnoughBatteryException extends RuntimeException {

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
