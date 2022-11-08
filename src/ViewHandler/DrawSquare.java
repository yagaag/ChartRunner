package ViewHandler;
import DataHandler.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A DrawableComposite that decorates drawings with square marks
 *
 * @author yagaa
 * @version 1.0
 * @see DrawableComposite
 * @see Drawable
 */
public class DrawSquare extends DrawableComposite implements Drawable {

    /**
     * Draw in composed elements and then decorate each Point with square marks
     *
     * @param panel The JPanel to be drawn on
     * @param points The list of Points that need to be drawn
     */
    @Override
    public void draw(JPanel panel, ArrayList<Point> points) {
        super.draw(panel, points);
        Graphics g = panel.getGraphics();
        g.setColor(Color.red);
        for(Point pt: points) {
            g.fillRect(pt.xCoord()-4, pt.yCoord()-4, 8, 8);
            g.drawRect(pt.xCoord()-4, pt.yCoord()-4, 8, 8);
        }
    }
}