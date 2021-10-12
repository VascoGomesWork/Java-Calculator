package com.example.calculator.operations;

public class Subtraction extends OperationWith2Numbers implements Operation {

    public Subtraction(double inputedNumber1, double inputedNumber2) {
        super(inputedNumber1, inputedNumber2);
    }


    public double makeOperation() {
        return this.getNumber1() - this.getNumber2();
    }

    public String getOperator() {
        return "-";
    }

    @Override
    public int operationPrioritizing() {
        return 0;
    }
}
