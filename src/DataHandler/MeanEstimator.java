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

    public double updateMean(double mean, Point point, int length) {
        return ((mean * (length-1)) + point.yCoord()) / length;
    }
}
