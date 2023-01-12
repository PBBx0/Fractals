package pbb.aesc.homework.fractal.geometric;

import pbb.aesc.homework.fractal.geometric.Curve;

public interface ReplaceFunction {
    public Curve getNext(double x1, double y1, double x2, double y2);
}
