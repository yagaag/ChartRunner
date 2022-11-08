package DataHandler;

/**
 *
 *
 * @author yagaa
 * @version 1.1
 * @see Point
 * @see DataGenerator
 */
public class PointDataAdapter implements PointFormatData {

    DataGenerator dataGenerator;

    /**
     *
     *
     * @param dataGenerator
     */
    public PointDataAdapter(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    /**
     *
     */
    public Point generatePoint(int x) {
        int y = dataGenerator.generateDataPoint();
        return new Point(x,y);
    }

    /**
     *
     */
    public void clearData() {
        dataGenerator.clearData();
    }

    /**
     *
     *
     * @return
     */
    public double getMean() {
        return dataGenerator.getMean();
    }
}
