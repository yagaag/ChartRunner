package DataHandler;

import ViewHandler.ViewConstants;

import java.util.ArrayList;
import java.util.Observable;

/**
 * An Observable class that generate new points to be charted
 *
 * @author yagaa
 * @version 1.1
 * @see PointFormatData
 */
public class PointGenerator extends Observable {

    PointFormatData pointFormatData;
    ArrayList<Point> points = new ArrayList<>();
    int x = 10;

    /**
     * Instantiates the PointGenerator class and its PointFormatData needed to use DataGenerator
     */
    public PointGenerator() {
        this.pointFormatData = new PointDataAdapter(new DataGenerator());
    }

    /**
     * Generates a new point
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
     * Repositions Points to accommodate view in panel
     */
    private void repositionPoints() {
        for(int i = 0; i < points.size(); i++) {
            points.get(i).setXCoord(points.get(i).xCoord()-20);
        }
        this.setChanged();
        this.notifyObservers("Reposition");
    }

    /**
     * Clears all generated Points
     */
    public void clearPoints() {
        points.clear();
        pointFormatData.clearData();
        x = 10;
    }

    /**
     * @return Copy of all generated points
     */
    public ArrayList<Point> getPoints() {
        return (ArrayList<Point>) points.clone();
    }

    /**
     * @return The latest generated point
     */
    public Point getLastPoint() {
        return points.get(points.size()-1);
    }

    /**
     * @return The mean of generated points
     */
    public double getMean() {
        return pointFormatData.getMean();
    }
}
