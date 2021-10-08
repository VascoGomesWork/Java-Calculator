package com.example.calculator.operations;

public class SubtractionTest implements Operation2{
    @Override
    public double makeOperation(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public String getOperator() {
        return "-";
    }
}
