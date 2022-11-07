package ViewHandler;

import DataHandler.DataGenerator;
import DataHandler.PointDataAdapter;
import DataHandler.PointsGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    JButton runButton = new JButton();
    PlotPanel simpleDrawPanel = new PlotPanel(10,0);
    PlotPanel mediumDrawPanel = new PlotPanel(10,239);
    PlotPanel complexDrawPanel = new PlotPanel(10,478);
    PointsGenerator pointsGenerator = new PointDataAdapter(new DataGenerator());

    public App() {

        pointsGenerator.addObserverPanel(simpleDrawPanel);
        pointsGenerator.addObserverPanel(mediumDrawPanel);
        pointsGenerator.addObserverPanel(complexDrawPanel);

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

    private void runCharting() {
        pointsGenerator.generateNewPoint();
        simpleDrawPanel.simpleDraw();
        mediumDrawPanel.mediumDraw();
        complexDrawPanel.complexDraw();
    }

    private void clearCharts() {
        pointsGenerator.clearPoints();
        simpleDrawPanel.clearPanel();
        mediumDrawPanel.clearPanel();
        complexDrawPanel.clearPanel();
    }

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
