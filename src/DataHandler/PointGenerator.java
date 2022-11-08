package DataHandler;

import ViewHandler.ViewConstants;

import java.util.ArrayList;
import java.util.Observable;

public class PointGenerator extends Observable {
    PointFormatData pointFormatData;
    ArrayList<Point> points = new ArrayList<>();
    int x = 10;

    /**
     *
     *
     *
     */
    public PointGenerator() {
        this.pointFormatData = new PointDataAdapter(new DataGenerator());
    }

    /**
     *
     */
    public void generateNewPoint() {
        Point pt = pointFormatData.generatePoint(x);
        points.add(pt);
        if (x > ViewConstants.panelWidth) {
            repositionPoints();
        }
        else {
            this.setChanged();
            this.notifyObservers("Add");
            x+=20;
        }
    }

    /**
     *
     */
    private void repositionPoints() {
        for(int i = 0; i < points.size(); i++) {
            points.get(i).setXCoord(points.get(i).xCoord()-20);
        }
        this.setChanged();
        this.notifyObservers("Reposition");
    }

    /**
     *
     */
    public void clearPoints() {
        points.clear();
        pointFormatData.clearData();
        x = 10;
    }

    /**
     *
     *
     * @return
     */
    public ArrayList<Point> getPoints() {
        return (ArrayList<Point>) points.clone();
    }

    /**
     *
     *
     * @return
     */
    public Point getLastPoint() {
        return points.get(points.size()-1);
    }

    /**
     *
     *
     * @return
     */
    public double getMean() {
        return pointFormatData.getMean();
    }
}
