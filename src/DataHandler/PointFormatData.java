package DataHandler;

import java.util.ArrayList;
import java.util.Observer;

/**
 * An interface that works with data of Point format
 *
 * @author yagaa
 * @version 1.1
 */
public interface PointFormatData {

    /**
     * Generate a new Point with ranged random y-coordinate
     *
     * @param x The x-Coordinate of the point to be generated
     * @return The generated Point
     */
    public Point generatePoint(int x);

    /**
     * Clears all Data Points generated so far
     */
    public void clearData();

    /**
     * Returns the mean of the data points generated so far
     *
     * @return Mean of the data points
     */
    public double getMean();
}
