package pbb.aesc.homework.fractal.geometric;

public class LeviCurveFunction implements ReplaceFunction {
    static final double SQRT2 = 1.414213562;
    @Override
    public Curve getNext(double x1, double y1, double x2, double y2) {
        Curve result = new Curve();
        result.xPoints.add((x1 + x2) / 2. - (y2 - y1) / 2.);
        result.yPoints.add((y1 + y2) / 2. + (x2 - x1) / 2.);
        return result;
    }
}
