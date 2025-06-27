package com.leandersonandre.optimization.function;

/**
 * Cross-in-Tray Function
 * https://www.sfu.ca/~ssurjano/crossit.html
 * 
 */
public class CrossInTrayFunction implements Function {
  private final static double MIN_VALUE[] = { -10, -10 };
  private final static double MAX_VALUE[] = { 10, 10 };

  @Override
  public double evaluate(double[] x) {
    validateAndFixDomain(x);
    double x1 = x[0];
    double x2 = x[1];
    double exp = Math.abs(100 - (Math.sqrt(x1 * x1 + x2 * x2) / Math.PI));
    double value = Math.sin(x1) * Math.sin(x2) * Math.exp(exp);
    return -0.0001 * Math.pow(Math.abs(value) + 1, 0.1);
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
    for (int i = 0; i < 2; i++) {
      solution[i] = MIN_VALUE[i] + (MAX_VALUE[i] - MIN_VALUE[i]) * Math.random();
    }
  }
}
