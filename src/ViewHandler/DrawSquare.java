package ViewHandler;

import java.awt.*;
import java.util.ArrayList;
import DataHandler.Point;

public class DrawSquare extends DrawableDecorator implements Drawable {

    @Override
    public void draw(PlotPanel panel, ArrayList<Point> points) {
        super.draw(panel, points);
        Graphics g = panel.getGraphics();
        g.setColor(Color.red);
        for(Point pt: points) {
            g.fillRect(pt.xCoord()-4, pt.yCoord()-4, 8, 8);
            g.drawRect(pt.xCoord()-4, pt.yCoord()-4, 8, 8);
        }
    }
}