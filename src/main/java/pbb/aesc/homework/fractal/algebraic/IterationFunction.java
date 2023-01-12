package pbb.aesc.homework.fractal.algebraic;

import pbb.aesc.homework.fractal.algebraic.Complex;

public abstract class IterationFunction {
    public abstract Complex next(Complex x);

    public int getGrad(Complex x, double inf, int k) {
        int i = 0;
        for (; i < k && x.mod() < inf; x = next(x), ++i);
        return i;
    }
}
