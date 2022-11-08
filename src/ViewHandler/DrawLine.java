package ViewHandler;
import DataHandler.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 *
 * @author yagaa
 * @version 1.0
 * @see DrawableComposite
 * @see Drawable
 */
public class DrawLine implements Drawable {

    /**
     *
     *
     * @param panel
     * @param points
     */
    @Override
    public void draw(JPanel panel, ArrayList<Point> points) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.blue);
        for (int i = 0; i < points.size()-1; i++) {
            Point pt1 = points.get(i);
            Point pt2 = points.get(i + 1);
            g.drawLine(pt1.xCoord(), pt1.yCoord(), pt2.xCoord(), pt2.yCoord());
        }
    }
}
