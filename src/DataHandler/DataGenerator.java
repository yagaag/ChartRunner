package DataHandler;
import ViewHandler.ViewConstants;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 *
 * @author yagaa
 * @version 1.1
 */
public class DataGenerator extends Observable {

    ArrayList<Integer> dataArray = new ArrayList<>();
    static int Ymin = 20;
    static int Ymax = ViewConstants.panelHeight-20;
    double mean = 0.0;

    /**
     * Generates a new data point within a pre-specified range
     * @return The generated data point
     */
    public int generateDataPoint() {
        int dataPoint = (int) (Math.random() * ((Ymax - Ymin) + 1) + Ymin);
        dataArray.add(dataPoint);
        mean = MeanEstimator.getInstance().updateMean(mean, dataPoint, dataArray.size());
        return dataPoint;
    }

    /**
     * Clears all stored data points and resets mean
     */
    public void clearData() {
        dataArray.clear();
        mean = 0.0;
    }

    /**
     * @return Complete array of data points
     */
    public ArrayList<Integer> getDataArray() {
        return (ArrayList<Integer>) dataArray.clone();
    }

    /**
     * @return Mean of the set of data points
     */
    public double getMean() {
        return mean;
    }
}