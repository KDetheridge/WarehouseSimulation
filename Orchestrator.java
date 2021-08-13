import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

public class Orchestrator {
    HashMap<Job,Robot> activeJobs = new HashMap<Job,Robot>();
    //Robot[] robots;
    HashMap<String, Robot> robots = new HashMap<String,Robot>();
    ChargingStation[] chargingStations;
    // An array of objects that handle the packing of items.
    // Robots will receive a job request and deliver to a specific packing station.
    PackingStation[] packingStations;
    // An array of shelf objects that contain the items to be packed
    Shelf[] shelves;
    Order[] orders;
    Job[] jobs;
    Entity[][] floorTemplate;
    int floorSizeX;
    int floorSizeY;
    int floorArea;
    // define a new comparator to be used for sorting the map entries of the
    // neighbourList
    Comparator<Map.Entry<Position, Integer>> mapEntrySortValueAsc = new Comparator<Map.Entry<Position, Integer>>() {
        public int compare(Map.Entry<Position, Integer> o1, Map.Entry<Position, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    };

    public static void main(String args[]) {

        Warehouse wh = new Warehouse();

        Orchestrator o = new Orchestrator(wh.getRobots(), wh.getOrders(), wh.getPackingStations(),
                wh.getChargingStations(), wh.getShelves(), wh.getFloorPlan());

        for (Position p : o.createRoute(new Position(0, 0), new Position(4, 4))) {
            System.out.println(p.toString() + ": " + p.getX() + "," + p.getY());
        }
    }

    public Orchestrator(Robot[] robots, Order[] orders, PackingStation[] packingStations,
            ChargingStation[] chargingStations, Shelf[] shelves, Entity[][] floorTemplate) {

        this.robots = robots;

        this.orders = orders;

        this.shelves = shelves;
        this.packingStations = packingStations;
        
        this.floorTemplate = floorTemplate;
        this.floorSizeX = floorTemplate.length;
        this.floorSizeY = floorTemplate[0].length;
        this.floorArea = floorSizeX * floorSizeY;

        createJobs(orders);
    }
    public Shelf getShelfById(String shelfId){
        for (Shelf s : shelves){
            if (s.getId().equals(shelfId)){
                return s;
            }
        }
        return null;
    }
    public void createJobs(Order[] orders){
        for (Order order : orders) {
            //get the shelf using the shelf ID
            String shelfId = order.getShelfId();
            Shelf shelf = getShelfById(shelfId);
            //if the shelf could not be found,
            if (shelf == null){
                //stop the simulation.
                System.exit(1);

            }

            //get the location of the shelf
            Position shelfPos = shelf.getPos();

            //Find an available Robot
            //calculate a route to the shelf

        }
    }

    /**
     * Creates a Linked List of Position objects that a robot should inherit to
     * represent it moving along the path specified.
     * 
     * @author Kieran Detheridge
     * @param startPos A Position object representing the starting position of the
     *                 route.
     * @param endPos   A Position object representing the ending position of the
     *                 route.
     * @return a LinkedList of Position objects representing the sequence of
     *         cartesian coordinates along the path to reach the target or an empty
     *         linked list if a route is not found.
     */
    public LinkedList<Position> createRoute(Position startPos, Position endPos) {
        // A Linked list that will contain the route for this recursion.
        LinkedList<Position> route = new LinkedList<Position>();

        // Create a new HashMap to contain the neighbouring positions and the distance
        // to the endPos
        HashMap<Position, Integer> neighbours = new HashMap<Position, Integer>();
        // Create new position objects to refer to the immediate neighbours of the
        // current position
        Position top = new Position(startPos.getX(), startPos.getY() + 1);
        Position bottom = new Position(startPos.getX(), startPos.getY() - 1);
        Position left = new Position(startPos.getX() - 1, startPos.getY());
        Position right = new Position(startPos.getX() + 1, startPos.getY());
        // Add all neighbours and their distance from the target to a HashMap
        neighbours.put(top, endPos.calculateManhattanDistance(top));
        neighbours.put(bottom, endPos.calculateManhattanDistance(bottom));
        neighbours.put(left, endPos.calculateManhattanDistance(left));
        neighbours.put(right, endPos.calculateManhattanDistance(right));
        HashSet<Position> neighbourSet = new HashSet<Position>(neighbours.keySet());

        // remove all of the already visited nodes from the neighbourSet.
        // Sets created this way are backed by the map, so and changes here
        // are reflected in the neighbours map.
        System.out.println("Neighbour Set: " + neighbourSet);
        // Create an array list from the entries in the neighbours map
        ArrayList<Map.Entry<Position, Integer>> neighbourList = new ArrayList<Map.Entry<Position, Integer>>(
                neighbours.entrySet());

        // sort the arraylist using the comparator defined above
        Collections.sort(neighbourList, mapEntrySortValueAsc);

        // for each neighbour,
        for (Map.Entry<Position, Integer> entry : neighbourList) {
            // Get the position object
            Position neighbourPos = entry.getKey();

            System.out.println("neighbour: (" + neighbourPos.getX() + ", " + neighbourPos.getY() + ") Distance: "
                    + entry.getValue());

            // if this entry is not a valid position,
            if (!neighbourPos.isValid(floorSizeX, floorSizeY)) {
                // skip this neighbour
                continue;
            }
            // if this neighbour is the target,
            if (neighbourPos.equals(endPos)) {

                // add the current node and the neighbour to the route and return
                route.add(startPos);
                route.add(neighbourPos);
                return route;
            }

            else {
                // look at this neighbour
                LinkedList<Position> nextPos = createRoute(neighbourPos, endPos);
                // if there was a route returned,
                if (!nextPos.isEmpty()) {
                    // add it to the route linked list
                    route.add(startPos);
                    route.addAll(nextPos);
                    // return the completed route
                    return route;
                }
            }
        }
        // Nothing found on this recursion, so return an empty linked list.
        return new LinkedList<Position>();

    }
}
