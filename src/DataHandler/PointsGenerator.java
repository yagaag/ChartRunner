package DataHandler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public interface PointsGenerator {
    public void generateNewPoint();
    public void clearPoints();
    public ArrayList<Point> getPoints();
    public Point getLastPoint();
    public double getMean();
    public void addObserverPanel(Observer o);
}
