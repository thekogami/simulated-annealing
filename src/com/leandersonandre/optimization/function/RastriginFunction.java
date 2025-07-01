package com.leandersonandre.optimization.function;

/**
 * Rastrigin Function
 * https://www.sfu.ca/~ssurjano/rastr.html
 */
public class RastriginFunction implements Function {
    private final static double MIN_VALUE = -5.12;
    private final static double MAX_VALUE = 5.12;

    @Override
    public double evaluate(double[] x) {
        validateAndFixDomain(x);
        double sum = 10 * x.length;
        for (int i = 0; i < x.length; i++) {
            sum += (x[i] * x[i] - 10 * Math.cos(2 * Math.PI * x[i]));
        }
        return sum;
    }

    @Override
    public void validateAndFixDomain(double[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] < MIN_VALUE) {
                x[i] = MIN_VALUE;
            }
            if (x[i] > MAX_VALUE) {
                x[i] = MAX_VALUE;
            }
        }
    }

    @Override
    public void generateRandomSolution(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = MIN_VALUE + (MAX_VALUE - MIN_VALUE) * Math.random();
        }
    }
}
