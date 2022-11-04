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
        g.fillRect(
                points.get(points.size()-1).xCoord()-4,
                points.get(points.size()-1).yCoord()-4,
                8,
                8
        );
        g.drawRect(
                points.get(points.size()-1).xCoord()-4,
                points.get(points.size()-1).yCoord()-4,
                8,
                8
        );
    }
}