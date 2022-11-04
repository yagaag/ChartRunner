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
    PlotPanel mediumDrawPanel = new PlotPanel(10,240);
    PlotPanel complexDrawPanel = new PlotPanel(10,480);

    public App() {
        runButton.addActionListener(this);
        runButton.setBounds(80,725,240,60);
        runButton.setText("Run");
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
        Thread thread = new Thread() {
            public void run() {
                runButton.setText("Running...");
                simpleDrawPanel.clear();
                mediumDrawPanel.clear();
                complexDrawPanel.clear();
                DataGenerator pointGenerator = new DataGenerator();
                pointGenerator.addObserver(simpleDrawPanel);
                pointGenerator.addObserver(mediumDrawPanel);
                pointGenerator.addObserver(complexDrawPanel);
                for (int i = 0; i < 37; i++) {
                    CustomTimer.timeDelay(200);
                    pointGenerator.generateNewPoint();
                    simpleDrawPanel.simpleDraw();
                    mediumDrawPanel.mediumDraw();
                    complexDrawPanel.complexDraw();
                }
                runButton.setText("Run");
            }
        };
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.runApp();
    }
}
