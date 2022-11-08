package ViewHandler;

import DataHandler.DataGenerator;
import DataHandler.PointDataAdapter;
import DataHandler.PointFormatData;
import DataHandler.PointGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class App generates data points and visualizes them in the form of simple, medium and complex charts
 *
 * @author yagaa
 * @version 1.0
 */
public class App extends JFrame implements ActionListener {

    JButton runButton = new JButton();
    PlotPanel simpleDrawPanel = new PlotPanel(10,0);
    PlotPanel mediumDrawPanel = new PlotPanel(10,239);
    PlotPanel complexDrawPanel = new PlotPanel(10,478);
    PointGenerator pointGenerator = new PointGenerator();

    /**
     * Sets up UI components and displays the JFrame
     */
    public App() {

        pointGenerator.addObserver(simpleDrawPanel);
        pointGenerator.addObserver(mediumDrawPanel);
        pointGenerator.addObserver(complexDrawPanel);

        runButton.setText("Run");
        runButton.addActionListener(this);
        runButton.setBounds(20,725,180,60);
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.addActionListener(this);
        clearButton.setBounds(200,725,180,60);

        this.setPreferredSize(new Dimension(400,820));
        this.setLayout(null);
        this.add(simpleDrawPanel);
        this.add(mediumDrawPanel);
        this.add(complexDrawPanel);
        this.add(runButton);
        this.add(clearButton);
        this.add(new Panel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Generates data and runs the charting process.
     */
    private void runCharting() {
        pointGenerator.generateNewPoint();
        simpleDrawPanel.simpleDraw();
        mediumDrawPanel.mediumDraw();
        complexDrawPanel.complexDraw();
    }

    /**
     * Clears all charts
     */
    private void clearCharts() {
        pointGenerator.clearPoints();
        simpleDrawPanel.clearPanel();
        mediumDrawPanel.clearPanel();
        complexDrawPanel.clearPanel();
    }

    /**
     * Runs/clears the app upon button press
     *
     * @param e ActionEvent passed by key press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runButton) {
            this.runCharting();
        }
        else {
            this.clearCharts();
        }
    }
}
