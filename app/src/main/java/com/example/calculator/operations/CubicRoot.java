package com.example.calculator.operations;

public class CubicRoot extends OperationWith1Number implements Operation {

    public CubicRoot(int inputedNumber) {
        super(inputedNumber);
    }

    @Override
    public double makeOperation() {
        return Integer.parseInt(Double.toString(Math.cbrt(this.getNumber())));
    }

    @Override
    public String getOperator() {
        return null;
    }

    @Override
    public int operationPrioritizing() {
        return 0;
    }
}
