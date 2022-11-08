package DataHandler;

/**
 * An Adapter class that converts generated range random data to Point
 *
 * @author yagaa
 * @version 1.1
 * @see Point
 * @see DataGenerator
 */
public class PointDataAdapter implements PointFormatData {

    DataGenerator dataGenerator;

    /**
     * Instantiate a PointDataAdapter and it's aggregated DataGenerator
     *
     * @param dataGenerator
     */
    public PointDataAdapter(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    /**
     * Generate a new Point with ranged random y-coordinate
     *
     * @param x The x-Coordinate of the point to be generated
     * @return The generated Point
     */
    public Point generatePoint(int x) {
        int y = dataGenerator.generateDataPoint();
        return new Point(x,y);
    }

    /**
     * Clears all Data Points generated so far
     */
    public void clearData() {
        dataGenerator.clearData();
    }

    /**
     * Returns the mean of the data points generated so far
     *
     * @return Mean of the data points
     */
    public double getMean() {
        return dataGenerator.getMean();
    }
}
