package ViewHandler;

import DataHandler.DataGenerator;
import DataHandler.MeanEstimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    JButton runButton = new JButton();
    PlotPanel simpleDrawPanel = new PlotPanel(10,0);
    PlotPanel mediumDrawPanel = new PlotPanel(10,239);
    PlotPanel complexDrawPanel = new PlotPanel(10,478);
    DataGenerator pointGenerator = new DataGenerator();

    public App() {
        runButton.addActionListener(this);
        runButton.setBounds(80,725,240,60);
        runButton.setText("Run");
        pointGenerator.addObserver(simpleDrawPanel);
        pointGenerator.addObserver(mediumDrawPanel);
        pointGenerator.addObserver(complexDrawPanel);
        this.setPreferredSize(new Dimension(400,820));
        this.setLayout(null);
        this.add(simpleDrawPanel);
        this.add(mediumDrawPanel);
        this.add(complexDrawPanel);
        this.add(runButton);
        this.add(new Panel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void runApp() {
        pointGenerator.generateNewPoint();
        simpleDrawPanel.simpleDraw();
        mediumDrawPanel.mediumDraw();
        complexDrawPanel.complexDraw();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.runApp();
    }
}
