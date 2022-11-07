package DataHandler;

import ViewHandler.ViewConstants;

import java.util.ArrayList;
import java.util.Observable;

public class DataGenerator extends Observable {

    ArrayList<Integer> dataArray = new ArrayList<>();
    static int Ymin = 20;
    static int Ymax = ViewConstants.panelHeight-20;
    double mean = 0.0;

    public int generateDataPoint() {
        int dataPoint = (int) (Math.random() * ((Ymax - Ymin) + 1) + Ymin);
        dataArray.add(dataPoint);
        mean = MeanEstimator.getInstance().updateMean(mean, dataPoint, dataArray.size());
        return dataPoint;
    }

    public void clearData() {
        dataArray.clear();
        mean = 0.0;
    }

    public ArrayList<Integer> getDataArray() {
        return (ArrayList<Integer>) dataArray.clone();
    }

    public double getMean() {
        return mean;
    }
}