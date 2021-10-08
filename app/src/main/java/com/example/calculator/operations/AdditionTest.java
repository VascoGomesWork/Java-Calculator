package com.example.calculator.operations;

public class AdditionTest implements Operation2{

    @Override
    public double makeOperation(double inputedNumber1, double inputedNumber2) {
        return inputedNumber1 + inputedNumber2;
    }

    @Override
    public String getOperator() {
        return "+";
    }
}
