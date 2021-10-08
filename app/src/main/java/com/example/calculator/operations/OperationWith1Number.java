package com.example.calculator.operations;

public abstract class OperationWith1Number implements Operation {

    private final int number;

    public OperationWith1Number(int inputedNumber){
        this.number = inputedNumber;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationWith1Number that = (OperationWith1Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
