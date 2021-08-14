public abstract class Entity {

    private String id;

    private Position pos;

    public Warehouse warehouse;

    public Entity(String id, Position pos, Warehouse warehouse) {
        this.id = id;
        if (!pos.isValid(warehouse.getFloorPlanX(), warehouse.getFloorPlanY())){
            System.out.println("Invalid Entity Position: " + pos);
            System.out.println("Stopping simulation");
            System.exit(1);
        }
        this.pos = pos;
        this.warehouse = warehouse;
    }

    public Position getPos() {
        return pos;
    }

    /**
     * @author Kieran Detheridge
     * @return the horizontal component of the position
     */
    public int getXPos() {
        return this.pos.getX();
    }

    /**
     * @author Kieran Detheridge
     * @return the vertical component of the position
     */
    public int getYPos() {
        return this.pos.getY();
    }

    public void setXPos(int newX) {
        this.pos.setX(newX);
    }

    public void setYPos(int newY) {
        this.pos.setY(newY);
    }

    /**
     * @author Kieran Detheridge
     * @return string representation of the UUID for an object.
     */
    public String getId() {

        return this.id.toString();
    }
}