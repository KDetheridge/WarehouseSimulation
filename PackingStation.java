public class PackingStation extends Entity{
    public Order currentOrder;
    public PackingStation(String id, Position pos, Warehouse warehouse){
        super(id, pos, warehouse);
    }

    public Order getOrder(){
        return this.currentOrder;
    }

    public void setOrder(Order newOrder){
        this.currentOrder = newOrder;
    }
    public void tick(){

    }
}