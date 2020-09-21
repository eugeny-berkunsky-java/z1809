package ua.mk.berkut.te;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class IntegralCalculator extends AbstractCalculator implements Calculator {

    public IntegralCalculator(double start, double finish, int n, DoubleUnaryOperator f) {
        super(start, finish, n, f);
    }

    @Override
    public double calculate() {
        double h = (getFinish() - getStart()) / getN();
        return IntStream.range(0, getN())
                .mapToDouble(i -> getStart() + i * h)
                .map(getF())
                .map(y -> y * h)
                .sum();
    }
}
