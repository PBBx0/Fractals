package pbb.aesc.homework.fractal.geometric;

import java.util.ArrayList;
import java.util.List;

public class Curve {
    public ArrayList<Double> xPoints, yPoints;
    public Curve() {
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();
    }

    void add(Curve other) {
        this.xPoints.addAll(other.xPoints);
        this.yPoints.addAll(other.yPoints);
    }

    void transform(ReplaceFunction f, boolean cycle) {
        List<Double> oldXPoints = xPoints;
        List<Double> oldYPoints = yPoints;
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();
        for (int i = 0; i < oldXPoints.size() - 1; ++i) {
            xPoints.add(oldXPoints.get(i));
            yPoints.add(oldYPoints.get(i));
            add(f.getNext(oldXPoints.get(i), oldYPoints.get(i), oldXPoints.get(i + 1), oldYPoints.get(i + 1)));
        }
        xPoints.add(oldXPoints.get(oldXPoints.size() - 1));
        yPoints.add(oldYPoints.get(oldYPoints.size() - 1));
        if (cycle) {
            add(f.getNext(oldXPoints.get(oldXPoints.size() - 1), oldYPoints.get(oldYPoints.size() - 1), oldXPoints.get(0), oldYPoints.get(0)));
        }
    }
}