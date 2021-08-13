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

    public Order(String orderId, String shelfId,String packingStationId, int numItems) {
        this.orderId = orderId;
        this.packingStationId = packingStationId;
        this.shelfId = shelfId;
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