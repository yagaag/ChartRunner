package DataHandler;

import ViewHandler.ViewConstants;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class PointDataAdapter extends Observable implements PointsGenerator {

    DataGenerator dataGenerator;
    ArrayList<Point> points = new ArrayList<>();
    int x = 10;
    private ArrayList<Observer> obs;

    public PointDataAdapter(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    public void generateNewPoint() {
        int y = dataGenerator.generateDataPoint();
        Point pt = new Point(x,y);
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

    private void repositionPoints() {
        for(int i = 0; i< points.size(); i++) {
            points.get(i).setXCoord(points.get(i).xCoord()-20);
        }
        this.setChanged();
        this.notifyObservers("Reposition");
    }

    public void clearPoints() {
        points.clear();
        dataGenerator.clearData();
        x = 10;
    }

    public ArrayList<Point> getPoints() {
        return (ArrayList<Point>) points.clone();
    }

    public Point getLastPoint() {
        return points.get(points.size()-1);
    }

    public double getMean() {
        return dataGenerator.getMean();
    }

    @Override
    public void addObserverPanel(Observer o) {
        super.addObserver(o);
    }
}
