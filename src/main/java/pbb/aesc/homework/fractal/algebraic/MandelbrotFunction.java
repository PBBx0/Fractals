package pbb.aesc.homework.fractal.algebraic;

import pbb.aesc.homework.fractal.algebraic.Complex;
import pbb.aesc.homework.fractal.algebraic.IterationFunction;

public class MandelbrotFunction extends IterationFunction {
    Complex z0 = new Complex(0, 0);
    Complex z = z0;
    public MandelbrotFunction(Complex z0) {
        this.z0 = z0;
    }
    public Complex next(Complex x) {
        return z = z.pow(4).add(x);
    }
    @Override
    public int getGrad(Complex x, double inf, int k) {
        int i = 0;
        for (z = z0; i < k && z.mod() < inf; next(x), ++i);
        return i;
    }
}
