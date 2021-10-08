package com.example.calculator.operations;

import java.util.ArrayList;
import java.util.List;

public class OperationChooser {

    char operator;
    double operationResult = 0;
    int num = 0;

    public double chooseOperation(String operationString, int j){
        //Gets the substring without the "="
        operationString = operationString.substring(0, j - 1);
        //Gets the operator chosen by the user
        operator = getOperationSign(operationString);

        //Choose the Operation to be made without having to make tons of If's statements

        String stringOperator = operator + "";

        Operation addiction = new Addiction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
        Operation subtraction = new Subtraction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
        Operation multiply = new Multiply(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
        Operation division = new Division(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));

        List<Operation> operationList = new ArrayList<>();
        operationList.add(addiction);
        operationList.add(subtraction);
        operationList.add(multiply);
        operationList.add(division);

        for (Operation operation : operationList) {
            if(operation.getOperator().equals(stringOperator)){
                operationResult = operation.makeOperation();
                System.out.println("Operation Result = " + operation.makeOperation());
            }
        }

                            /*if(stringOperator.equals("+")){
                                operation = new Addiction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
                                System.out.println("Operation Result = " + operation.makeOperation());
                                }
                                if(stringOperator.equals("-")){
                                    operation = new Subtraction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
                                    System.out.println("Operation Result = " + operation.makeOperation());
                                    }
                                    if(stringOperator.equals("*")){
                                        operation = new Multiply(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
                                        System.out.println("Operation Result = " + operation.makeOperation());
                                        }
                                        if(stringOperator.equals("/")){
                                            operation = new Division(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
                                            System.out.println("Operation Result = " + operation.makeOperation());
                                            }*/

        System.out.println("Operation String = " + operationString);
        System.out.println("Operation String Number 1 = " + operationString.substring(0, operationString.indexOf(operator)));
        System.out.println("Operation String Number 2 = " + operationString.substring(operationString.indexOf(operator) + 1));
        return operationResult;
    }

    private char getOperationSign(String operationString) {
        char localOperator  = ' ';
        //Gets the operation sign
        for (int k = 0; k < operationString.length(); k++) {
            try {
                num = Integer.parseInt(operationString.charAt(k) + "");
            } catch (Exception e) {
                localOperator = operationString.charAt(k);
            }
        }
        System.out.println("Operator = " + localOperator);
        return localOperator;
    }
}
