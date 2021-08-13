
import java.util.LinkedList;
public class Job{
    String id;
    Order order;
    LinkedList<Position> route;
    public Job(String id,Order order, LinkedList<Position> route){
        this.id = id;
        this.order = order;
        this.route = route;

    }

    public String getId(){
        return this.id;
    }
    public String getOrderId(){
        return this.order.getId();
    }
}