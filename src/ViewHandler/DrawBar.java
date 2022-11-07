package ViewHandler;

import java.awt.*;
import DataHandler.Point;
import java.util.ArrayList;

public class DrawBar extends DrawableComposite implements Drawable {

    @Override
    public void draw(PlotPanel panel, ArrayList<Point> points) {
        super.draw(panel, points);
        Graphics g = panel.getGraphics();
        g.setColor(ViewConstants.barColor);
        for(Point pt: points) {
            g.fillRect(pt.xCoord() - 4, pt.yCoord() + 4, 8, panel.getHeight() - pt.yCoord());
            g.drawRect(pt.xCoord() - 4, pt.yCoord() + 4, 8, panel.getHeight() - pt.yCoord());
        }
    }
}
