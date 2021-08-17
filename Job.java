
import Structures.LinkedList;
public class Job{
    String id;
    Order order;
    LinkedList<String> actions;
    LinkedList<LinkedList<Position>> fullRoute;
    LinkedList<Position> currentRoute;
    public Job(String id,Order order, LinkedList<LinkedList<Position>> route, LinkedList<String> actions){
        this.id = id;
        this.order = order;
        this.fullRoute = fullRoute;
        this.actions = actions;

    }
    public Job(String id,Order order, LinkedList<LinkedList<Position>> fullRoute){
        this.id = id;
        this.order = order;
        this.fullRoute = fullRoute;
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
        //update the current route variable
        currentRoute = fullRoute.iterator().next();
        //return the new route to follow
        return currentRoute;
    }
    public Position getNextPosition(){
        if (currentRoute.head().hasNext()){
            return currentRoute.head().getNext().getData();
        }
        else{
            return null;
        }
    }

    public String getNextAction(){
        return this.actions.head().getNext().getData();
    }
    public LinkedList<LinkedList<Position>> getRoutes(){
        return this.fullRoute;
    }
    public String toString(){
        return new String("Job ID: " + this.id + "\nOrder ID: " + this.getOrderId() + "\nRoute References: " + this.fullRoute.toString());
    }
}