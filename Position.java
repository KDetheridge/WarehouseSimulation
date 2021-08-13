/**
 * A class to represent the position of entities and objects within a Cartesian
 * grid.
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        this.y = newY;
    }
    /**
     * 
     * @param maxX the maximum allowable x value for the position
     * @param maxY the maximum allowable x value for the position
     * @return true if the position is valid, false if not.
     */
    public boolean isValid(int maxX, int maxY){
        //if this position is outside the bounds specified
        if(this.x < 0 || this.y < 0 || this.x > maxX || this.y > maxY){
            //return false
            return false;
        }

        return true;
    }
    /**
     * Find the absolute distance between two points.
     * Uses the formula |x1 - x2| + |y1 - y2|
     * @param pos the position for which to calculate the distance to
     * @return the absolute distance
     */
    public int calculateManhattanDistance(Position pos){
        return Math.abs(this.x - pos.getX()) + Math.abs(this.y - pos.getY());
    }

    public boolean equals(Position pos){   
        return (this.x == pos.getX() && this.y == pos.getY());
    }
}