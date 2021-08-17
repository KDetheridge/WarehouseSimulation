import java.util.HashMap;
public class Warehouse {
    private HashMap<String,Robot> robots = new HashMap<String,Robot>();
    private HashMap<String,ChargingStation> chargingStations = new HashMap<String,ChargingStation>();
    // An array of objects that handle the packing of items.
    // Robots will receive a job request and deliver to a specific packing station.
    private HashMap<String,PackingStation> packingStations = new HashMap<String,PackingStation>();
    // An array of shelf objects that contain the items to be packed
    private HashMap<String,Shelf> shelves = new HashMap<String,Shelf>();
    private HashMap<String,Order> orders = new HashMap<String,Order>();

    private int floorPlanX;
    private int floorPlanY;
    private Entity[][] floorPlan;
    private Entity[][] robotFloorPlan;

    public Warehouse() {
        this.floorPlanX = 10;
        this.floorPlanY = 10;
        floorPlan = new Entity[floorPlanX][floorPlanY];
        robotFloorPlan = new Entity[floorPlanX][floorPlanY];
        int chargeUnits = 3;
        ChargingStation cs = new ChargingStation("cs1",new Position(5, 1),chargeUnits, this);
        PackingStation ps = new PackingStation("ps1",new Position(1, 1), this);
        Robot r = new Robot("r1",30, 30,cs, new Position(5, 1), this);
        Shelf s = new Shelf("s1",new Position(4,4), this);

        chargingStations.put(cs.getId(),cs);
        packingStations.put(ps.getId(),ps);
        robots.put(r.getId(), r);

        shelves.put(s.getId(),s);



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

    public HashMap<String,Order> getOrders() {
        return orders;
    }

    public Order getNextOrder() {
        //Retrieve the "next" value from the hashmap.
        HashMap.Entry<String,Order> orderEntry = orders.entrySet().iterator().next();
        return orderEntry.getValue();
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