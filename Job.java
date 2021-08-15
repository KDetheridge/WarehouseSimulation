
import Structures.LinkedList;
public class Job{
    String id;
    Order order;
    LinkedList<String> actions;
    LinkedList<LinkedList<Position>> route;
    public Job(String id,Order order, LinkedList<LinkedList<Position>> route, LinkedList<String> actions){
        this.id = id;
        this.order = order;
        this.route = route;
        this.actions = actions;

    }

    public String getId(){
        return this.id;
    }
    public String getOrderId(){
        return this.order.getId();
    }

    public LinkedList<Position> getNextRoute(){
        return route.next().getData();
    }
}