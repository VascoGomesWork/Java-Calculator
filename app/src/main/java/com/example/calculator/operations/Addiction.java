package com.example.calculator.operations;

public class Addiction extends OperationWith2Numbers {

    public Addiction(double inputedNumber1, double inputedNumber2) {
        super(inputedNumber1, inputedNumber2);
    }

    public double makeOperation(){
        return this.getNumber1() + this.getNumber2();
    }

    @Override
    public double makeOperation(double num1, double num2) {
        return num1 + num2;
    }

    public String getOperator(){
        return "+";
    }
}
