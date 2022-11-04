package ViewHandler;

import DataHandler.Point;
import java.util.ArrayList;


public interface Drawable {
    public void draw(PlotPanel panel, ArrayList<Point> points);
}
