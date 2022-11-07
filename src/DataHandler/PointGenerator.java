package DataHandler;

import ViewHandler.ViewConstants;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Observable;

public class PointGenerator extends Observable {

    ArrayList<Point> points = new ArrayList<>();
    double mean = 0.0;
    int x = 10;
    static int Ymin = 20;
    static int Ymax = ViewConstants.panelHeight-20;

    public void generateNewPoint() {
        int y = (int) (Math.random() * ((Ymax - Ymin) + 1) + Ymin);
        Point pt = new Point(x,y);
        points.add(pt);
        mean = MeanEstimator.getInstance().updateMean(mean, pt, points.size());
        System.out.println("Points:");
        for(Point ptt: points) {
            System.out.println(ptt.xCoord());
        }
        System.out.println("Done");
        System.out.println(points.size());
        System.out.println(x);
        if (x > ViewConstants.panelWidth) {
            System.out.println("reposs");
            repositionPoints();
        }
        else {
            this.setChanged();
            this.notifyObservers("Add");
        }
        x = x + 20;
    }

    private void repositionPoints() {
        for(int i=0; i<points.size(); i++) {
            points.get(i).setXCoord(points.get(i).xCoord()-20);
        }
        x-=20;
        this.setChanged();
        this.notifyObservers("Reposition");
    }

    public void clearPoints() {
        points.clear();
        x = 10;
        mean = 0.0;
    }

    public ArrayList<Point> getPoints() {
        return (ArrayList<Point>) points.clone();
    }

    public Point getLastPoint() {
        return points.get(points.size()-1);
    }

    public double getMean() {
        return mean;
    }
}
