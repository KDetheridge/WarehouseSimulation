public class ChargingStation extends Entity{
    /**
     * A custom exception to indicate that a charging station already has a robot assigned.
     * The robot assigned should be immutable to prevent misalignment of robot - charging station relationships,
     * which might cause two robots to share the same charging station and therefore induce a collision.
     * @author Kieran Detheridge
     */
    public class RobotAlreadyAssignedException extends Exception{
        public RobotAlreadyAssignedException(String msg){
            super(msg);
        }
        

    }
    Robot robot = null;
    public ChargingStation(String id,Position pos, Warehouse warehouse){
        super(id, pos, warehouse);

    }
    /**
     * @author Kieran Detheridge
     * @param r the robot object to set to this charging station.
     * @throws RobotAlreadyAssignedException
     */
    public void setRobot(Robot r) throws RobotAlreadyAssignedException{
        if (this.robot == null){
        this.robot = r;
        }
        throw new RobotAlreadyAssignedException("Charging station (" + this.getId() +") already has a robot ("+ r.getId() +") assigned.");
    }

    public Robot getRobot(){
        return this.robot;
    }
}