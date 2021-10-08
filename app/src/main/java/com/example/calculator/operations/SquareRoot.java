package com.example.calculator.operations;

public class SquareRoot extends OperationWith1Number implements Operation {

    public SquareRoot(int inputedNumber) {
        super(inputedNumber);
    }

    @Override
    public double makeOperation() {
        return Integer.parseInt(Double.toString(Math.sqrt(this.getNumber())));
    }

    @Override
    public String getOperator() {
        return null;
    }
}
