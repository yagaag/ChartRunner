package DataHandler;

/**
 *
 *
 * @author yagaa
 * @version 1.0
 */
public class MeanEstimator {
    private static MeanEstimator instance;

    /**
     *
     */
    private MeanEstimator(){}

    /**
     *
     *
     * @return
     */
    public static MeanEstimator getInstance() {
        if (instance == null) {
            instance = new MeanEstimator();
        }
        return instance;
    }

    /**
     *
     *
     * @param mean
     * @param dataPoint
     * @param length
     */
    public double updateMean(double mean, int dataPoint, int length) {
        return ((mean * (length-1)) + dataPoint) / length;
    }
}
