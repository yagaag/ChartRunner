package DataHandler;

public class Point {

    private int x;
    private int y;

    public Point(int xCoordinate, int yCoordinate) {
        x = xCoordinate;
        y = yCoordinate;
    }

    /**
     * @return x-coordinate of the point
     */
    public int xCoord() {
        return x;
    }

    /**
     * @return y-coordinate of the point
     */
    public int yCoord() {
        return y;
    }

    public void setXCoord(int xCoordinate) {
        x = xCoordinate;
    }

    public void setYCoord(int yCoordinate) {
        y = yCoordinate;
    }
}
