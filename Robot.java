/**
 * A robot class to be used in the simulation. This is an active agent that can
 * navigate the grid and complete actions on given tiles as instructed by the
 * orchestrator.
 * 
 * @author Kieran Detheridge
 */
public class Robot extends Entity {
    private int chargeCapacity;
    private int currentCharge;
    private ChargingStation chargingStation;
    private Job currentJob;
    private Position currentPosition;
    private int numOfItems;

    /**
     * @author Kieran Detheridge
     * @param chargeCapacity  the maximum allowable charge capacity of this robot.
     * @param startCharge     the initial charge of the robot.
     * @param jobId           the job ID that has been assigned to this robot
     * @param currentPosition the position that this robot will start at as an XY
     *                        grid reference.
     */
    public Robot(String id, int capacity, int startCharge, ChargingStation chargingStation, Job job,
            Position currentPosition, Warehouse warehouse) {
        super(id, currentPosition, warehouse);
        this.chargeCapacity = capacity;
        this.currentCharge = startCharge;
        this.chargingStation = chargingStation;
        this.currentJob = job;
        this.currentPosition = currentPosition;

    }

    /**
     * A secondary constructor for creating a robot without a job at instantiation
     * 
     * @author Kieran Detheridge
     * @param capacity        the maximum allowable charge capacity of this robot.
     * @param startCharge     the initial charge of the robot.
     * @param currentPosition the position that this robot will start at as an XY
     *                        grid reference.
     * 
     */
    public Robot(String id, int capacity, int startCharge, ChargingStation chargingStation, Position currentPosition,
            Warehouse warehouse) {
        super(id, currentPosition, warehouse);

        this.chargeCapacity = capacity;
        this.currentCharge = startCharge;
        this.currentPosition = currentPosition;
        this.chargingStation = chargingStation;

    }
    /**
     * @author Kieran Detheridge
     * @param id The ID to identify this robot
     * @param capacity the maximum charge capacity of this robot
     * @param startCharge the charge of this robot when initialised
     * @param chargingStation the charging station object of this robot
     * @param warehouse 
     */
    public Robot(String id, int capacity, int startCharge, ChargingStation chargingStation, Warehouse warehouse) {
super(id, chargingStation.getPos(), warehouse);

this.chargeCapacity = capacity;
this.currentCharge = startCharge;
this.chargingStation = chargingStation;

}

    /**
     * Sets the current job of a robot by allocating it a job ID if a job isn't
     * already assigned.
     * 
     * @author Kieran Detheridge
     * @param newJobId The job ID of the new job to be assigned
     * @return boolean whether the job was assigned successfully or not.
     */
    public boolean setJob(Job job) {
        if (this.currentJob != null) {
            return false;
        }
        this.currentJob = job;
        return true;
    }

    public Job getJob(){
        return this.currentJob;
    }
    /**
     * End the current job for this robot by setting the jobId to null.
     * @author Kieran Detheridge
     */
    public void endJob(){
        this.currentJob = null;
    }

    /**
     * Increase the charge of a robot by a given number of units. Performs the logic
     * for charging a robot. The currentCharge must be less than the chargeCapacity
     *  before increasing.
     * 
     * @author Kieran Detheridge
     * @param units the number of units to charge the robot by.
     */
    public void increaseCharge(int units) {
        if (currentCharge < chargeCapacity){
            currentCharge += units;

        }
    }

    /**
     * Decrease the charge of a robot by a given number of units. Performs the logic
     * for using charge of a robot.
     * 
     * @author Kieran Detheridge
     * @param units the number of units to reduce the charge by.
     */
    public void decreaseCharge(int units) {
        currentCharge -= units;
    }

    /**
     * Simulate the pickup of an item by incrementing the count of number of items
     * on a robot.
     * 
     * @author Kieran Detheridge
     * @return number of items after adding this one
     */
    public int pickItem() {
        numOfItems += 1;
        return numOfItems;

    }

    /**
     * Simulate the dropping of an item by decrementing the count of number of items
     * on a robot.
     * 
     * @author Kieran Detheridge
     * @return number of items after dropping one
     */
    public int dropItem() {
        numOfItems -= 1;
        return numOfItems;

    }

    /**
     * Indicates whether a robot can move into a specified position or not
     * 
     * @author Kieran Detheridge
     * @param pos the position to check
     * @return true if the next position is free, false if not.
     */
    public boolean checkNextPosition(Position pos) {
        return (warehouse.getRobotFloorPlan()[pos.getX()][pos.getY()] == null);
    }

    /**
     * @author Kieran Detheridge
     * @param pos the position for the robot to move into.
     * @return true if successful, false if failed.
     */
    public boolean move(Position pos) {
        int currX = currentPosition.getX();
        int currY = currentPosition.getY();
        int nextX = pos.getX();
        int nextY = pos.getY();
        // If the next space is occupied or more than one space away
        if (Math.abs(currX - nextX) + Math.abs(currY - nextY) > 1) {
            System.out.println("Robot in position '" + this.getPos().toString() + " cannot move into position "
                    + pos.toString() + " because it is more than one space away.");
            System.exit(1);
        }
        if (checkNextPosition(pos) == false) {
            // return failure flag
            return false;
        }
        // next space is empty and one or zero spaces away
        // update current pos
        this.currentPosition.setX(pos.getX());
        this.currentPosition.setY(pos.getY());
        // return successful flag
        return true;
    }

    /**
     * 
     * @return the charging station object for this robot.
     */
    public ChargingStation getChargingStation() {
        return this.chargingStation;
    }

    /**
     * @author Kieran Detheridge
     * @return integer representing the charge of the robot
     */
    public int getCurrentCharge() {
        return currentCharge;
    }
}