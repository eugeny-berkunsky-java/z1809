package ua.mk.berkut.te;

import java.util.function.DoubleUnaryOperator;

public class ThreadCalculator implements Calculator, Runnable {

    private final IntegralCalculator calculator;
    private final Main main;

    public ThreadCalculator(double start, double finish, int n, DoubleUnaryOperator f, Main main) {
        calculator = new IntegralCalculator(start, finish, n, f);
        this.main = main;
    }

    @Override
    public double calculate() {
        return calculator.calculate();
    }

    @Override
    public void run() {
        double result = calculate();
        main.sendResult(result);
    }
}
