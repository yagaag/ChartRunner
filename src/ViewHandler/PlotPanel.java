package ViewHandler;
import DataHandler.Point;
import DataHandler.PointFormatData;
import DataHandler.PointGenerator;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Panel that plots generated points with Drawables
 *
 * @author yagaa
 * @version 1.0c
 * @see Drawable
 */
public class PlotPanel extends JPanel implements Observer {

    ArrayList<Point> points = new ArrayList<>();
    double mean = 0.0;

    /**
     * Initialize a PlotPanel with start position mentioned
     *
     * @param x X-coordinate of start position
     * @param y Y-coordinate of start position
     */
    public PlotPanel(int x, int y) {
        this.setBorder(BorderFactory.createLineBorder(ViewConstants.accentColor, 2));
        this.setBounds(x,y, ViewConstants.panelWidth, ViewConstants.panelHeight);
        this.setBackground(Color.white);
    }

    /**
     * Visualizes the mean of generated points as a line
     */
    private void drawMean() {
        Graphics g = this.getGraphics();
        g.setColor(Color.black);
        g.drawLine(0,(int)mean, this.getWidth(), (int)mean+4);
    }

    /**
     * Draws a line plot of generated points
     */
    public void simpleDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        Drawable drawLine = new DrawLine();
        drawLine.draw(this, points);
    }

    /**
     * Draws a marked line plot of generated points
     */
    public void mediumDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        Drawable drawLine = new DrawLine();
        DrawableComposite drawSquare = new DrawSquare();
        drawSquare.addDrawable(drawLine);
        drawSquare.draw(this, points);
    }

    /**
     * Draws a marked line plot with bar indicators of generated points
     */
    public void complexDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        Drawable drawLine = new DrawLine();
        DrawableComposite drawSquare = new DrawSquare();
        DrawableComposite drawBar = new DrawBar();
        drawSquare.addDrawable(drawLine);
        drawBar.addDrawable(drawSquare);
        drawBar.draw(this, points);
    }

    /**
     * Clears the panel
     */
    public void clearPanel() {
        this.setBorder(BorderFactory.createLineBorder(ViewConstants.accentColor, 2));
        points.clear();
    }

    /**
     * Updates the stored points when new points are generated
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        if((String) arg == "Add") {
            points.add(((PointGenerator) o).getLastPoint());
        }
        else if((String) arg == "Reposition") {
            points = ((PointGenerator) o).getPoints();
        }
        mean = ((PointGenerator) o).getMean();
    }
}
