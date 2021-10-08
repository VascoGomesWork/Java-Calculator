package com.example.calculator.operations;

public class NumberToCubic extends OperationWith1Number implements Operation {

    public NumberToCubic(int inputedNumber) {
        super(inputedNumber);
    }

    @Override
    public double makeOperation() {
        return Integer.parseInt(Double.toString(Math.pow(this.getNumber(), 3)));
    }

    @Override
    public String getOperator() {
        return null;
    }
}
