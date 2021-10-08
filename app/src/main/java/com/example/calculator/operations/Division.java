package com.example.calculator.operations;

public class Division extends OperationWith2Numbers implements Operation {

    public Division(double inputedNumber1, double inputedNumber2) {
        super(inputedNumber1, inputedNumber2);
    }

    @Override
    public double makeOperation() {
        return this.getNumber1() / this.getNumber2();
    }


    public String getOperator() {
        return "/";
    }
}
