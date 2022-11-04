package DataHandler;

import java.util.ArrayList;
import java.util.Observable;

public class DataGenerator extends Observable {
    ArrayList<Point> points = new ArrayList<>();
    double mean = 0.0;
    int currX = 0;
    static int Ymin = 20;
    static int Ymax = 220;
    public void generateNewPoint() {
        int x = currX + 10;
        currX = x;
        int y = (int) (Math.random() * ((Ymax - Ymin) + 1) + Ymin);
        points.add(new Point(x,y));
        mean = MeanEstimator.getInstance().updateMean(mean, points.get(points.size()-1), points.size());
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public double getMean() {
        return mean;
    }

    public Point getLastPoint() {
        return points.get(points.size()-1);
    }
}
