package pbb.aesc.homework.fractal.geometric;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GeometricFractalFrame extends JFrame {
    Curve curve;
    boolean cycle = false;
    int maxStep = 6;
    int curStep = 0;
    Color curveColor = Color.BLACK;
    class DrawingPanel extends JPanel {
        static final int STROKE = 1;
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setStroke(new BasicStroke(STROKE));
            g2D.setColor(curveColor);
            int n = curve.xPoints.size();
            for (int i = 0; i < n - 1; ++i) {
                g2D.drawLine(curve.xPoints.get(i).intValue(), curve.yPoints.get(i).intValue(),
                        curve.xPoints.get(i + 1).intValue(), curve.yPoints.get(i + 1).intValue());
            }
            if (cycle) {
                g2D.drawLine(curve.xPoints.get(n - 1).intValue(), curve.yPoints.get(n - 1).intValue(),
                        curve.xPoints.get(0).intValue(), curve.yPoints.get(0).intValue());
            }
        }
        public DrawingPanel() {
            super();
            repaint();
        }
    }

    ReplaceFunction func;
    DrawingPanel panel;

    void updateFractal() {
        if (curStep == maxStep) {
            return;
        }
        curStep++;
        curve.transform(func, cycle);
        panel.repaint();
    }

    public void setColor(Color color) {
        curveColor = color;
        panel.repaint();
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }

    public GeometricFractalFrame(Curve curve, ReplaceFunction function, boolean cycle) {
        super("Geometric Fractal");
        this.curve = curve;
        this.func = function;
        this.cycle = cycle;
        panel = new DrawingPanel();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    dispose();
                    setUndecorated(!isUndecorated());
                    setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    updateFractal();
                    add(panel);
                }
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(panel);
        setVisible(true);
    }
}
