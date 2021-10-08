package com.example.calculator.operations;

public class NumberToSquare extends OperationWith1Number implements Operation {

    public NumberToSquare(int inputedNumber) {
        super(inputedNumber);
    }

    @Override
    public double makeOperation() {
        return Integer.parseInt(Double.toString(Math.pow(this.getNumber(), 2)));
    }

    @Override
    public String getOperator() {
        return null;
    }
}
