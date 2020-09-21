package ua.mk.berkut.te;

public class Main {

    private double total;
    private int finished;

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        double a = 0;
        double b = Math.PI;
        int n = 1000_000_000;
        int nThreads = 100;

        total = 0;
        finished = 0;
        long startTime = System.currentTimeMillis();
        double delta = (b - a) / nThreads;
        for (int i = 0; i < nThreads; i++) {
            new Thread(
                    new ThreadCalculator(
                            a + i * delta,
                            a + (i+1) * delta,
                            n/nThreads,
                            Math::sin,
                            this
                    )
            ).start();
        }

        synchronized (this) {
            while (finished < nThreads) {
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("total = " + total);
        System.out.println("finishTime-startTime = " + (finishTime - startTime));

//        Calculator calculator = new IntegralCalculator(a,b,n,Math::sin);
//        double v = calculator.calculate();
//        System.out.println("v = " + v);
    }

    public synchronized void sendResult(double result) {
        total += result;
        finished++;
        notify();
    }
}
