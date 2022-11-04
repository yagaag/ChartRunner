package ViewHandler;

import java.awt.*;
import java.util.ArrayList;
import DataHandler.Point;

public abstract class DrawableDecorator implements Drawable {
    private ArrayList<Drawable> drawableList = new ArrayList<>();
    public DrawableDecorator() {

    }
    public void addDrawable(Drawable drawable) {
        drawableList.add(drawable);
    }
    public void draw(PlotPanel panel, ArrayList<Point> points) {
        for (Drawable drawable: drawableList) {
            drawable.draw(panel, points);
        }
    }
}
