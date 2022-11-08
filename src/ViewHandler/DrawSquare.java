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
public class DrawSquare extends DrawableComposite implements Drawable {

    /**
     *
     *
     * @param panel
     * @param points
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