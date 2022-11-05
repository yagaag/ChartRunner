package DataHandler;

import java.util.ArrayList;
import java.util.Observable;

public class DataGenerator extends Observable {
    ArrayList<Point> points = new ArrayList<>();
    double mean = 0.0;
    int currX = -9;
    static int Ymin = 20;
    static int Ymax = 220;
    public void generateNewPoint() {
        int x = currX + 20;
        currX = x;
        int y = (int) (Math.random() * ((Ymax - Ymin) + 1) + Ymin);
        points.add(new Point(x,y));
        mean = MeanEstimator.getInstance().updateMean(mean, points.get(points.size()-1), points.size());
        if (points.size() > 19) {
            repositionPoints();
        }
        else {
            this.setChanged();
            this.notifyObservers("Add");
        }
    }

    private void repositionPoints() {
        for(int i=0; i<points.size(); i++) {
            points.get(i).setXCoord(points.get(i).xCoord()-20);
        }
        currX-=20;
        this.setChanged();
        this.notifyObservers("Reposition");
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point getLastPoint() {
        return points.get(points.size()-1);
    }

    public double getMean() {
        return mean;
    }
}
