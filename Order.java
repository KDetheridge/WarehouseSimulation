/**
 * A class to contain the required information for an order.
 * Has a unique ID orderId to identify this order
 * Contains a shelfId to indicate the shelf required to complete this order
 * Specifies the number of items to collect in numItems
 */
public class Order {
    private String orderId;
    private String shelfId;
    private int numItems;

    public Order(String orderId, String shelfId, int numItems) {
        this.orderId = orderId;
        this.shelfId = shelfId;
        this.numItems = numItems;
    }

    public String getShelfId(){
        return this.shelfId;
    }
}