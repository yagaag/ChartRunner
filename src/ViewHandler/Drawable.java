package ViewHandler;

import DataHandler.Point;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 *
 * @author yagaa
 * @version 1.0
 */
public interface Drawable {

    /**
     *
     *
     * @param panel
     * @param points
     */
    public void draw(JPanel panel, ArrayList<Point> points);
}
