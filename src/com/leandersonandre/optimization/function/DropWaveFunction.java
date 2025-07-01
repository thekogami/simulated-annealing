package com.leandersonandre.optimization.function;

/**
 * Drop-Wave Function
 * https://www.sfu.ca/~ssurjano/drop.html
 */
public class DropWaveFunction implements Function {
  private final static double MIN_VALUE[] = { -5.12, -5.12 };
  private final static double MAX_VALUE[] = { 5.12, 5.12 };

  @Override
  public double evaluate(double[] x) {
    if (x.length != 2) {
      throw new IllegalArgumentException("DropWaveFunction requires a 2-dimensional input vector.");
    }
    validateAndFixDomain(x);
    double x1 = x[0];
    double x2 = x[1];
    double numerator = 1 + Math.cos(12 * Math.sqrt(x1 * x1 + x2 * x2));
    double denominator = 0.5 * (x1 * x1 + x2 * x2) + 2;
    return -numerator / denominator;
  }

  @Override
  public void validateAndFixDomain(double[] x) {
    for (int i = 0; i < x.length; i++) {
      if (x[i] < MIN_VALUE[i]) {
        x[i] = MIN_VALUE[i];
      }
      if (x[i] > MAX_VALUE[i]) {
        x[i] = MAX_VALUE[i];
      }
    }
  }

  @Override
  public void generateRandomSolution(double[] solution) {
    for (int i = 0; i < solution.length; i++) {
      solution[i] = MIN_VALUE[i] + (MAX_VALUE[i] - MIN_VALUE[i]) * Math.random();
    }
  }
}
