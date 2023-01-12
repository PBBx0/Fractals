package pbb.aesc.homework.fractal.geometric;

public class KochCurveFunction implements ReplaceFunction {
    static final double COS60 = 0.5;
    static final double SIN60 = 0.866025404;
    static final double K1 = 1. / 3;
    static final double K2 = 2. / 3;
    @Override
    public Curve getNext(double x1, double y1, double x2, double y2) {
        double[] xPoints = new double[3];
        double[] yPoints = new double[3];
        xPoints[0] = x1 * K2 + x2 * K1;
        yPoints[0] = y1 * K2 + y2 * K1;
        xPoints[2] = x1 * K1 + x2 * K2;
        yPoints[2] = y1 * K1 + y2 * K2;
        xPoints[1] = (xPoints[2] - xPoints[0]) * COS60 - (yPoints[2] - yPoints[0]) * SIN60 + xPoints[0];
        yPoints[1] = (xPoints[2] - xPoints[0]) * SIN60 + (yPoints[2] - yPoints[0]) * COS60 + yPoints[0];
        Curve result = new Curve();
        for (int i = 0; i < 3; ++i) {
            result.xPoints.add(xPoints[i]);
            result.yPoints.add(yPoints[i]);
        }
        return result;
    }
}
