package pbb.aesc.homework.fractal.algebraic;
import pbb.aesc.homework.fractal.palettes.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class AlgebraicFractalFrame extends JFrame {
    Palette palette;
    IterationFunction f;
    double INF = 10;
    int MAX_ITER = 60;
    class DrawingPanel extends JPanel {
        final int xp0 = 0;
        final int yp0 = 0;
        final int xp1 = 1000;
        final int yp1 = 1000;
        double x0 = -2, x1 = 2, y0 = 2, y1 = -2;
        Complex get(int xp, int yp) {
            return new Complex(x0 + (double)(xp - xp0) / (xp1 - xp0) * (x1 - x0), y0 + (double)(yp - yp0) / (yp1 - yp0) * (y1 - y0));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int i = xp0; i < xp1; ++i) {
                for (int j = yp0; j < yp1; ++j) {
                    int k = f.getGrad(get(i, j), INF, MAX_ITER);
                    g2d.setColor(palette.get(k, k == MAX_ITER));
                    g2d.fillRect(i, j, 1, 1);
                }
            }
            addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    double k = Math.pow(1.003, e.getPreciseWheelRotation());
                    Complex c = get(x, y);
                    x0 = c.x + (x0 - c.x) * k;
                    y0 = c.y + (y0 - c.y) * k;
                    x1 = c.x + (x1 - c.x) * k;
                    y1 = c.y + (y1 - c.y) * k;
                    repaint();
                }
            });
        }
    }
    DrawingPanel panel;

    public AlgebraicFractalFrame(Palette palette, IterationFunction function) {
        super("Algebraic fractal");
        this.palette = palette;
        this.f = function;
        panel = new DrawingPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
        setResizable(false);
        add(panel);
        panel.repaint();
        setVisible(true);
    }
}
