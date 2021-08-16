/**
 * A class to contain the required information for an order.
 * Has a unique ID orderId to identify this order
 * Contains a shelfId to indicate the shelf required to complete this order
 * Specifies the number of items to collect in numItems
 */
public class Order {
    private String orderId;
    private String shelfId;
    private String packingStationId;
    private int numItems;
    public class InvalidIDException extends Exception {
        public InvalidIDException(String msg){
            super(msg);
        }
    }

    public class InvalidNumItemsException extends Exception {
        public InvalidNumItemsException(String msg){
            super(msg);
        }
    }
    public Order(String orderId, String shelfId,String packingStationId, int numItems, Warehouse warehouse) throws InvalidIDException, InvalidNumItemsException {
        if (warehouse.getOrders().keySet().contains(orderId)){
            throw new InvalidIDException("An order already exists with ID " + orderId);
            
        }
        this.orderId = orderId;
        if (!warehouse.getPackingStations().keySet().contains(packingStationId)){
            throw new InvalidIDException("Packing Station " + packingStationId + " does not exist.");
            
        }
        this.packingStationId = packingStationId;
        if (!warehouse.getShelves().keySet().contains(shelfId)){
            throw new InvalidIDException("Shelf " + shelfId + " does not exist.");
            
        }
        this.shelfId = shelfId;
        if (numItems == 0){
            throw new InvalidNumItemsException(numItems + " is not a valid number of items.");
        }
        this.numItems = numItems;
    }

    public String getShelfId(){
        return this.shelfId;
    }
    public String getId(){
        return this.orderId;
    }
    public String getPackingStationId(){
        return this.packingStationId;
    }
    public int getNumItems(){
        return this.numItems;
    }
}