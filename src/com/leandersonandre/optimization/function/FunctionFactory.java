package com.leandersonandre.optimization.function;

public class FunctionFactory {

    private static FunctionFactory instance;

    private FunctionFactory() {
    }

    public static FunctionFactory getInstance() {
        if (instance == null) {
            instance = new FunctionFactory();
        }
        return instance;
    }

    public Function getFunction(String functionName) {
        return switch (functionName) {
            case "ACKLEY" -> new AckleyFunction();
            case "BUKIN6" -> new BukinFunctionN6();
            case "CROSSINTRAY" -> new CrossInTrayFunction();
            case "DROPWAVE" -> new DropWaveFunction();
            default -> throw new IllegalArgumentException("Unknown function name: " + functionName);
        };
    }

}
