package ViewHandler;

import java.awt.*;
import DataHandler.Point;
import java.util.ArrayList;

public class DrawBar extends DrawableDecorator implements Drawable {

    @Override
    public void draw(PlotPanel panel, ArrayList<Point> points) {
        super.draw(panel, points);
        Graphics g = panel.getGraphics();
        g.setColor(Assets.barColor);
        g.fillRect(
                points.get(points.size()-1).xCoord()-4,
                points.get(points.size()-1).yCoord()+4,
                8,
                panel.getHeight()-points.get(points.size()-1).yCoord()
        );
        g.drawRect(
                points.get(points.size()-1).xCoord()-4,
                points.get(points.size()-1).yCoord()+4,
                8,
                panel.getHeight()-points.get(points.size()-1).yCoord()
        );
    }
}
