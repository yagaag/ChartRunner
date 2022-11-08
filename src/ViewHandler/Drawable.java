package ViewHandler;

import DataHandler.Point;

import javax.swing.*;
import java.util.ArrayList;

/**
 * An object that can draw Points on a JPanel
 *
 * @author yagaa
 * @version 1.0
 */
public interface Drawable {

    /**
     * Draw given Points in provided JPanel
     *
     * @param panel The JPanel to be drawn on
     * @param points The list of Points that need to be drawn
     */
    public void draw(JPanel panel, ArrayList<Point> points);
}
