package pbb.aesc.homework.fractal.algebraic;

public class Complex {
    double x, y;
    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Complex add(Complex c) {
        return new Complex(x + c.x, y + c.y);
    }
    public Complex sub(Complex c) {
        return new Complex(x - c.x, y - c.y);
    }
    public Complex mul(Complex c) {
        return new Complex(x * c.x - y * c.y, x * c.y + y * c.x);
    }
    public double mod() {
        return Math.sqrt(x * x + y * y);
    }
    public Complex pow(int p) {
        Complex res = new Complex(1, 0);
        Complex tmp = new Complex(x, y);
        for (; p > 0; p >>= 1) {
            if ((p & 1) == 1) {
                res = res.mul(tmp);
            }
            tmp = tmp.mul(tmp);
        }
        return res;
    }
}
