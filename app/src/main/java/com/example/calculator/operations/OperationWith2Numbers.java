package com.example.calculator.operations;

public abstract class OperationWith2Numbers implements Operation {


    private final double number1;
    private final double number2;

    public OperationWith2Numbers(double inputedNumber1, double inputedNumber2){
        this.number1 = inputedNumber1;
        this.number2 = inputedNumber2;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationWith2Numbers)) return false;
        OperationWith2Numbers that = (OperationWith2Numbers) o;
        return number1 == that.number1 &&
                number2 == that.number2;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
