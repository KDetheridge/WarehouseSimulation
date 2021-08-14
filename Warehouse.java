import java.util.HashMap;
public class Warehouse {
    private HashMap<String,Robot> robots;
    private HashMap<String,ChargingStation> chargingStations;
    // An array of objects that handle the packing of items.
    // Robots will receive a job request and deliver to a specific packing station.
    private HashMap<String,PackingStation> packingStations;
    // An array of shelf objects that contain the items to be packed
    private HashMap<String,Shelf> shelves;
    private Order[] orders;

    private int floorPlanX;
    private int floorPlanY;
    private Entity[][] floorPlan;
    private Entity[][] robotFloorPlan;

    public Warehouse() {
        this.floorPlanX = 10;
        this.floorPlanY = 10;
        ChargingStation cs = new ChargingStation("cs1",new Position(5, 1), this);
        PackingStation ps = new PackingStation("ps1",new Position(1, 1), this);
        Robot r = new Robot("r1",5, 5,cs, new Position(5, 1), this);
        Shelf s = new Shelf("s1",new Position(4,4), this);

        chargingStations.put(cs.getId(),cs);
        packingStations.put(ps.getId(),ps);
        robots.put(r.getId(), r);
        shelves.put(s.getId(),s);

        floorPlan = new Entity[floorPlanX][floorPlanY];
        robotFloorPlan = new Entity[floorPlanX][floorPlanY];

        floorPlan[cs.getXPos()][cs.getYPos()] = cs;
        floorPlan[ps.getXPos()][ps.getYPos()] = ps;
        floorPlan[s.getXPos()][s.getYPos()] = s;

        robotFloorPlan[r.getXPos()][r.getYPos()] = r;

    }

    public HashMap<String,Robot> getRobots() {
        return robots;
    }

    public HashMap<String,ChargingStation> getChargingStations() {
        return chargingStations;
    }

    public HashMap<String,PackingStation> getPackingStations() {
        return packingStations;
    }

    public HashMap<String,Shelf> getShelves() {
        return shelves;
    }

    public Order[] getOrders() {
        return orders;
    }

    public Order getNextOrder() {
        return orders[0];
    }

    /**
     * Check the status of a given position - populated or empty.
     * @author Kieran Detheridge
     * @param pos the position to be checked
     * @return true if the checked space is populated, false if not.
     */
    public boolean isPositionTaken(Position pos){
        return !(floorPlan[pos.getX()][pos.getY()] == null);

    }

    public Entity[][] getFloorPlan(){
        return floorPlan;
    }

    public int getFloorPlanX(){
        return floorPlanX;
    }
    public int getFloorPlanY(){
        return floorPlanY;
    }
    public Entity[][] getRobotFloorPlan(){
        return robotFloorPlan;
    }
}