package ViewHandler;
import DataHandler.DataGenerator;
import DataHandler.Point;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 *
 * @author yagaa
 * @version 1.0
 * @see Drawable
 */
public abstract class DrawableComposite implements Drawable {

    private ArrayList<Drawable> drawableList = new ArrayList<>();

    /**
     *
     *
     * @param drawable
     */
    public void addDrawable(Drawable drawable) {
        drawableList.add(drawable);
    }

    /**
     *
     *
     * @param drawable
     */
    public void removeDrawable(Drawable drawable) {
        drawableList.remove(drawable);
    }

    /**
     *
     *
     * @param panel
     * @param points
     */
    public void draw(JPanel panel, ArrayList<Point> points) {
        for (Drawable drawable: drawableList) {
            drawable.draw(panel, points);
        }
    }
}
