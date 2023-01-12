package pbb.aesc.homework.fractal;
import pbb.aesc.homework.fractal.algebraic.*;
import pbb.aesc.homework.fractal.geometric.*;
import pbb.aesc.homework.fractal.palettes.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /* Examples of geometric fractal usages

        Curve curve = new Curve();
        double xStart = 550.0;
        double yStart = 250.0;
        curve.xPoints.add(xStart + 0.);
        curve.xPoints.add(xStart + 729. / 2);
        curve.xPoints.add(xStart + 729.);
        curve.yPoints.add(yStart + 0. );
        curve.yPoints.add(yStart + 631.332519359);
        curve.yPoints.add(yStart + 0.);
        GeometricFractalFrame frame = new GeometricFractalFrame(curve, new KochCurveFunction(), true);
        frame.setColor(Color.BLUE);

        curve.xPoints.add(750.);
        curve.xPoints.add(1150.);
        curve.yPoints.add(250.);
        curve.yPoints.add(250.);
        curve.xPoints.add(1150.);
        curve.xPoints.add(750.);
        curve.yPoints.add(650.);
        curve.yPoints.add(650.);
        GeometricFractalFrame frame = new GeometricFractalFrame(curve, new QuadroKochCurveFunction(), true);

        curve.xPoints.add(750.);
        curve.xPoints.add(1150.);
        curve.yPoints.add(500.);
        curve.yPoints.add(500.);
        GeometricFractalFrame frame = new GeometricFractalFrame(curve, new LeviCurveFunction(), true);
        frame.setMaxStep(15);

        curve.xPoints.add(520.);
        curve.xPoints.add(1400.);
        curve.yPoints.add(500.);
        curve.yPoints.add(500.);
        GeometricFractalFrame frame = new GeometricFractalFrame(curve, new AngleCurveFunction(Math.PI * 0.4), true);
        frame.setMaxStep(7);


        curve.xPoints.add(750.);
        curve.xPoints.add(1150.);
        curve.yPoints.add(500.);
        curve.yPoints.add(500.);
        GeometricFractalFrame frame = new GeometricFractalFrame(curve, new AngleCurveFunction(Math.PI * 0.2), true);//0.2, 0.25, 0.4, 0.5
        frame.setMaxStep(7);
        */
        //Examples of algebraic fractals usage
        IterationFunction function = new IterationFunction() {
            final Complex c = new Complex(0.219, -0.714);//-1x, 0 ; 0.28 0.00113 ; 0.28 0.0113 ; -0.549653 0.003 ; 0.0228 -0.666
            @Override
            public Complex next(Complex x) {
                return x.pow(5).add(c);
            }
        };
        new AlgebraicFractalFrame(new PaletteSoManyLostSongs(), new MandelbrotFunction(new Complex(0, 0)));
        new AlgebraicFractalFrame(new PaletteIceAndFire(), function);
    }
}

