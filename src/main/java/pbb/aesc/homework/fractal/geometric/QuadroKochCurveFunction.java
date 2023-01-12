package pbb.aesc.homework.fractal.geometric;

public class QuadroKochCurveFunction implements ReplaceFunction {
    static final double K1 = 1. / 3;
    static final double EPS = 1e-3;
    @Override
    public Curve getNext(double x1, double y1, double x2, double y2) {
        double xLen = Math.abs(x1 - x2) * K1;
        double yLen = Math.abs(y1 - y2) * K1;
        double len = (xLen + yLen);
        double dist = -len;// len
        Curve result = new Curve();
        if (xLen < EPS) {
            if (y1 < y2) {
                result.xPoints.add(x1);
                result.xPoints.add(x1 + dist);
                result.xPoints.add(x1 + dist);
                result.xPoints.add(x1);

                result.yPoints.add(y1 + len);
                result.yPoints.add(y1 + len);
                result.yPoints.add(y2 - len);
                result.yPoints.add(y2 - len);
            } else {
                result.xPoints.add(x1);
                result.xPoints.add(x1 - dist);
                result.xPoints.add(x1 - dist);
                result.xPoints.add(x1);

                result.yPoints.add(y1 - len);
                result.yPoints.add(y1 - len);
                result.yPoints.add(y2 + len);
                result.yPoints.add(y2 + len);
            }
        } else {
            if (x1 < x2) {
                result.xPoints.add(x1 + len);
                result.xPoints.add(x1 + len);
                result.xPoints.add(x2 - len);
                result.xPoints.add(x2 - len);

                result.yPoints.add(y1);
                result.yPoints.add(y1 - dist);
                result.yPoints.add(y1 - dist);
                result.yPoints.add(y1);
            } else {
                result.xPoints.add(x1 - len);
                result.xPoints.add(x1 - len);
                result.xPoints.add(x2 + len);
                result.xPoints.add(x2 + len);

                result.yPoints.add(y1);
                result.yPoints.add(y1 + dist);
                result.yPoints.add(y1 + dist);
                result.yPoints.add(y1);
            }
        }
        return result;
    }
}
