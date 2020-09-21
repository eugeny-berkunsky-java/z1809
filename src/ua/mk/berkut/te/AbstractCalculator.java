package ua.mk.berkut.te;

import java.util.function.DoubleUnaryOperator;

public abstract class AbstractCalculator implements Calculator {
    private final double start;
    private final double finish;
    private final int n;
    private final DoubleUnaryOperator f;

    public AbstractCalculator(double start, double finish, int n, DoubleUnaryOperator f) {
        this.start = start;
        this.finish = finish;
        this.n = n;
        this.f = f;
    }

    public double getStart() {
        return start;
    }

    public double getFinish() {
        return finish;
    }

    public int getN() {
        return n;
    }

    public DoubleUnaryOperator getF() {
        return f;
    }
}
