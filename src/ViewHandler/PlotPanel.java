package ViewHandler;

import DataHandler.DataGenerator;
import DataHandler.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PlotPanel extends JPanel implements Observer {

    ArrayList<Point> points = new ArrayList<>();
    double mean = 0.0;

    public PlotPanel(int x, int y) {
        this.setBorder(BorderFactory.createLineBorder(Assets.accentColor, 2));
        this.setBounds(x,y,380,241);
        this.setBackground(Color.white);
    }

    public void clear() {
        this.setBorder(BorderFactory.createLineBorder(Assets.accentColor, 2));
        points.clear();
    }

    private void drawMean() {
        Graphics g = this.getGraphics();
        g.setColor(Color.black);
        g.drawLine(0,(int)mean, this.getWidth(), (int)mean+4);
    }

    public void simpleDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        DrawLine drawLine = new DrawLine();
        drawLine.draw(this, points);
    }

    public void mediumDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        DrawLine drawLine = new DrawLine();
        DrawSquare drawSquare = new DrawSquare();
        drawSquare.addDrawable(drawLine);
        drawSquare.draw(this, points);
    }

    public void complexDraw() {
        Graphics g = this.getGraphics();
        super.paint(g);
        drawMean();
        DrawLine drawLine = new DrawLine();
        DrawSquare drawSquare = new DrawSquare();
        DrawBar drawBar = new DrawBar();
        drawSquare.addDrawable(drawLine);
        drawBar.addDrawable(drawSquare);
        drawBar.draw(this, points);
    }

    @Override
    public void update(Observable o, Object arg) {
        if((String) arg == "Reposition") {
            points = ((DataGenerator) o).getPoints();
        }
        else {
            points.add(((DataGenerator) o).getLastPoint());
        }
        mean = ((DataGenerator) o).getMean();
    }
}
