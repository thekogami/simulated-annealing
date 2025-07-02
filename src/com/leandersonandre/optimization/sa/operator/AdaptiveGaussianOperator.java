package com.leandersonandre.optimization.sa.operator;

import java.util.Random;

public class AdaptiveGaussianOperator implements NeighborOperator {
    private Random random = new Random();
    private double baseStep;
    private double currentTemperature = 1.0;

    public AdaptiveGaussianOperator(double baseStep) {
        this.baseStep = baseStep;
    }

    public void setTemperature(double temperature) {
        this.currentTemperature = temperature;
    }

    @Override
    public void generateNeighbor(double[] x) {
        for (int i = 0; i < x.length; i++) {
            double adaptiveStep = baseStep * currentTemperature * random.nextGaussian();
            x[i] += adaptiveStep;
        }
    }
}

