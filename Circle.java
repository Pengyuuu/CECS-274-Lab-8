/**
 * Name: Eric Truong
 * Date: October 30, 2019
 * Description: Create a circle with given x, y coordinates and a radius, and be able put it into a linked list and be able to manipulate that list
 */

public class Circle {

    /**
     *A coordinate for the circle
     */
    private int x;

    /**
     *A coordinate for the circle
     */
    private int y;

    /**
     *Radius of the circle
     */
    private int radius;

    /**
     * Creates a new circle
     * @param x1        One length of the circle
     * @param y1        Second length of the circle
     * @param radius1   Radius of the circle
     */
    public Circle(int x1, int y1, int radius1){
        x = x1;
        y = y1;
        radius = radius1;
    }

    /**
     * Checks two circles to see if they're equal
     * @param o Second circle
     * @return  Returns whether they're equal or not
     */
    @Override
    public boolean equals(Object o){
        if (o instanceof Circle){
            Circle c = (Circle) o;
            return this.x == c.x && this.y == c.y && this.radius == c.radius;
        }
        return false;
    }

    /**
     * Puts x, y, and the radius into string format
     * @return  Returns x, y, and radius formatted
     */
    @Override
    public String toString(){
        return "("+x+","+y+") R = "+radius;
    }
}
