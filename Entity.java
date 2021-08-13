import java.util.UUID;

public abstract class Entity {

    private String id;

    private Position pos;

    public Warehouse warehouse;

    public Entity(Position pos, Warehouse warehouse) {
        this.id = UUID.randomUUID().toString();
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