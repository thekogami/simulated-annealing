package com.leandersonandre.optimization;

import com.leandersonandre.optimization.function.FunctionFactory;
import com.leandersonandre.optimization.sa.SimulatedAnnealing;
import com.leandersonandre.optimization.sa.operator.GaussianOperator;

public class Main {
//    public static void main(String[] args) {
//        SimulatedAnnealing sa = new SimulatedAnnealing(
//                FunctionFactory.getInstance().getFunction("RASTRIGIN"),
//                new GaussianOperator(0.3),
//                0.96,                    // Resfriamento bem mais gradual
//                150,                      // Menos iterações por temperatura
//                150_000,                  // Mantém total
//                10
//        );
//        sa.execute();
//    }


    public static void main(String[] args) {
    SimulatedAnnealing sa = new SimulatedAnnealing(
            FunctionFactory.getInstance().getFunction("DROPWAVE"),
            new GaussianOperator(0.3),
            0.97,
            300,
            150_000,
            2 // ✅ Drop-Wave é uma função bidimensional
    );
    sa.execute();
}
}
