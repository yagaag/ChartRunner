package DataHandler;

import java.util.ArrayList;

public class MeanEstimator {
    private static MeanEstimator instance;
    private MeanEstimator(){}

    public static MeanEstimator getInstance() {
        if (instance == null) {
            instance = new MeanEstimator();
        }
        return instance;
    }

    public double updateMean(double mean, int dataPoint, int length) {
        return ((mean * (length-1)) + dataPoint) / length;
    }
}
