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
    DrawableComposite drawableComposite;

    /**
     * Initialize a PlotPanel with start position mentioned
     *
     * @param x X-coordinate of start position
     * @param y Y-coordinate of start position
     */
    public PlotPanel(int x, int y, DrawStyle style) {
        this.setBorder(BorderFactory.createLineBorder(ViewConstants.accentColor, 2));
        this.setBounds(x,y, ViewConstants.panelWidth, ViewConstants.panelHeight);
        this.setBackground(Color.white);
        switch (style) {
            case SIMPLE -> setSimpleComposite();
            case MEDIUM -> setMediumComposite();
            case COMPLEX -> setComplexComposite();
        }
    }

    /**
     * Sets a line plot as composite
     */
    private void setSimpleComposite() {
        drawableComposite = new DrawableComposite();
        drawableComposite.addDrawable(new DrawLine());
    }

    /**
     * Set a line plot with square markings as composite
     */
    private void setMediumComposite() {
        drawableComposite = new DrawSquare();
        drawableComposite.addDrawable(new DrawLine());
    }

    /**
     * Set a line plot with square markings and a bar indicator as composite
     */
    private void setComplexComposite() {
        drawableComposite = new DrawBar();
        drawableComposite.addDrawable(new DrawSquare());
        drawableComposite.addDrawable(new DrawLine());
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
     * Draws the composite
     */
    public void draw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        drawableComposite.draw(this, points);
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