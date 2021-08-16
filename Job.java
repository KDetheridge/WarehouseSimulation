
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
    public Job(String id,Order order, LinkedList<LinkedList<Position>> route){
        this.id = id;
        this.order = order;
        this.route = route;
        LinkedList<String> actions = new  LinkedList<String>();
        actions.add("collect");
        actions.add("deliver");
        actions.add("charge");
        this.actions = actions;

    }

    public String getId(){
        return this.id;
    }
    public String getOrderId(){
        return this.order.getId();
    }

    public LinkedList<Position> getNextRoute(){
        return route.iterator().next();
    }
    public LinkedList<LinkedList<Position>> getRoutes(){
        return this.route;
    }
    public String toString(){
        return new String("Job ID: " + this.id + "\nOrder ID: " + this.getOrderId() + "\nRoute References: " + this.route.toString());
    }
}