package DataHandler;

/**
 * A single-instance MeanEstimator that estimates mean of data
 *
 * @author yagaa
 * @version 1.0
 */
public class MeanEstimator {
    private static MeanEstimator instance;

    /**
     * Private constructor to avoid multiple instances of MeanEstimator
     */
    private MeanEstimator(){}

    /**
     * @return Instance of the MeanEstimator
     */
    public static MeanEstimator getInstance() {
        if (instance == null) {
            instance = new MeanEstimator();
        }
        return instance;
    }

    /**
     * Updates and returns the mean for addition data point
     *
     * @param mean
     * @param dataPoint
     * @param length
     */
    public static double updateMean(double mean, int dataPoint, int length) {
        return ((mean * (length-1)) + dataPoint) / length;
    }
}
