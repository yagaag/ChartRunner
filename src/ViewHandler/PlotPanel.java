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
 *
 *
 * @author yagaa
 * @version 1.0
 */
public class PlotPanel extends JPanel implements Observer {

    ArrayList<Point> points = new ArrayList<>();
    double mean = 0.0;

    /**
     *
     *
     * @param x
     * @param y
     */
    public PlotPanel(int x, int y) {
        this.setBorder(BorderFactory.createLineBorder(ViewConstants.accentColor, 2));
        this.setBounds(x,y, ViewConstants.panelWidth, ViewConstants.panelHeight);
        this.setBackground(Color.white);
    }

    /**
     *
     */
    public void clearPanel() {
        this.setBorder(BorderFactory.createLineBorder(ViewConstants.accentColor, 2));
        points.clear();
    }

    /**
     *
     */
    private void drawMean() {
        Graphics g = this.getGraphics();
        g.setColor(Color.black);
        g.drawLine(0,(int)mean, this.getWidth(), (int)mean+4);
    }

    /**
     *
     */
    public void simpleDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        Drawable drawLine = new DrawLine();
        drawLine.draw(this, points);
    }

    /**
     *
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
     *
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
     *
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
