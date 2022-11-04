package ViewHandler;

import java.awt.*;
import java.util.ArrayList;
import DataHandler.Point;

public class DrawLine implements Drawable {

    @Override
    public void draw(PlotPanel panel, ArrayList<Point> points) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.blue);
        if (points.size() >= 2) {
            Point pt1 = points.get(points.size() - 2);
            Point pt2 = points.get(points.size() - 1);
            g.drawLine(pt1.xCoord(), pt1.yCoord(), pt2.xCoord(), pt2.yCoord());
        }
    }
}
