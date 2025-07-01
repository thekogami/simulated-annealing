package com.leandersonandre.optimization;

import com.leandersonandre.optimization.function.FunctionFactory;
import com.leandersonandre.optimization.sa.SimulatedAnnealing;
import com.leandersonandre.optimization.sa.operator.GaussianOperator;

public class Main {
    public static void main(String[] args) {
        SimulatedAnnealing sa = new SimulatedAnnealing(
                FunctionFactory.getInstance().getFunction("RASTRIGIN"),
                new GaussianOperator(0.3), // Passo menor para funções multimodais
                0.97,                      // Resfriamento mais suave
                300,                       // Mais iterações por temperatura
                150_000,                   // Iterações totais
                10                         // Número de variáveis (pode ajustar)
        );
        sa.execute();
    }


//    public static void main(String[] args) {
//        SimulatedAnnealing sa = new SimulatedAnnealing(
//                FunctionFactory.getInstance().getFunction("RASTRIGIN"),
//                new GaussianOperator(0.3), // Passo menor para funções multimodais
//                0.97,                      // Resfriamento mais suave
//                300,                       // Mais iterações por temperatura
//                150_000,                   // Iterações totais
//                10                         // Número de variáveis (pode ajustar)
//        );
//        sa.execute();
//    }

    //    public static void main(String[] args) {
//        SimulatedAnnealing sa = new SimulatedAnnealing(
//                FunctionFactory.getInstance().getFunction("DROPWAVE"),
//                new GaussianOperator(0.3),
//                0.97,
//                300,
//                150_000,
//                2 // ✅ Drop-Wave é uma função bidimensional
//        );
//        sa.execute();
//    }
}
