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
    private String jobId;
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
    public Robot(int capacity, int startCharge, String jobId, Position currentPosition, Warehouse warehouse) {
        super(currentPosition, warehouse);
        this.chargeCapacity = capacity;
        this.currentCharge = startCharge;
        this.jobId = jobId;
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
    public Robot(int capacity, int startCharge, Position currentPosition, Warehouse warehouse) {
        super(currentPosition, warehouse);

        this.chargeCapacity = capacity;
        this.currentCharge = startCharge;
        this.currentPosition = currentPosition;

    }

    /**
     * Sets the current job of a robot by allocating it a job ID if a job isn't
     * already assigned.
     * 
     * @author Kieran Detheridge
     * @param newJobId The job ID of the new job to be assigned
     * @return boolean whether the job was assigned successfully or not.
     */
    public boolean setJob(String newJobId) {
        if (jobId != null) {
            return false;
        }
        this.jobId = newJobId;
        return true;
    }

    /**
     * Increase the charge of a robot by a given number of units. Performs the logic
     * for charging a robot.
     * 
     * @author Kieran Detheridge
     * @param units the number of units to charge the robot by.
     */
    public void increaseCharge(int units) {
        currentCharge += units;
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

    public boolean checkNextPosition(Position pos) {
        return !(warehouse.getRobotFloorPlan()[pos.getX()][pos.getY()] == null);
    }

    public boolean move(Position pos) {
        int currX = currentPosition.getX();
        int currY = currentPosition.getY();
        int nextX = pos.getX();
        int nextY = pos.getY();
        // If the next space is occupied or more than one space away
        if (checkNextPosition(pos) == false || Math.abs(currX - nextX) + Math.abs(currY - nextY) > 1) {
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
}