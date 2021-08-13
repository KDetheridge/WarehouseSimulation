public class Warehouse {
    Robot[] robots;
    ChargingStation[] chargingStations;
    // An array of objects that handle the packing of items.
    // Robots will receive a job request and deliver to a specific packing station.
    PackingStation[] packingStations;
    // An array of shelf objects that contain the items to be packed
    Shelf[] shelves;
    Order[] orders;
    Entity[][] floorPlan;
    Entity[][] robotFloorPlan;

    public Warehouse() {
        ChargingStation cs = new ChargingStation(new Position(5, 1), this);
        PackingStation ps = new PackingStation(new Position(1, 1), this);
        Robot r = new Robot(5, 5, new Position(5, 1), this);
        Shelf s = new Shelf(new Position(4,4), this);

        floorPlan = new Entity[10][10];
        robotFloorPlan = new Entity[10][10];

        floorPlan[cs.getXPos()][cs.getYPos()] = cs;
        floorPlan[ps.getXPos()][ps.getYPos()] = ps;
        floorPlan[s.getXPos()][s.getYPos()] = s;

        robotFloorPlan[r.getXPos()][r.getYPos()] = r;

    }

    public Robot[] getRobots() {
        return robots;
    }

    public ChargingStation[] getChargingStations() {
        return chargingStations;
    }

    public PackingStation[] getPackingStations() {
        return packingStations;
    }

    public Shelf[] getShelves() {
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
    public Entity[][] getRobotFloorPlan(){
        return robotFloorPlan;
    }
}