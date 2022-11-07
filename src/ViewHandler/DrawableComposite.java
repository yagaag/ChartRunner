package ViewHandler;

import java.util.ArrayList;
import DataHandler.Point;

public abstract class DrawableComposite implements Drawable {
    private ArrayList<Drawable> drawableList = new ArrayList<>();

    public void addDrawable(Drawable drawable) {
        drawableList.add(drawable);
    }

    public void removeDrawable(Drawable drawable) {
        drawableList.remove(drawable);
    }

    public void draw(PlotPanel panel, ArrayList<Point> points) {
        for (Drawable drawable: drawableList) {
            drawable.draw(panel, points);
        }
    }
}
