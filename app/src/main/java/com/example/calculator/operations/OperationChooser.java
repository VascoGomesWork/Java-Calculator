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

        //TODO - Do not do with If's statements, use dynamic polymorphism somehow

        String stringOperator = operator + "";

        Operation2 additionTest = new AdditionTest();
        Operation2 subtractionTest = new SubtractionTest();
        List<Operation2> operationList = new ArrayList<>();
        operationList.add(additionTest);
        operationList.add(subtractionTest);

        for (Operation2 operation2 : operationList) {
            if(operation2.getOperator().equals(stringOperator)){
                operationResult = operation2.makeOperation(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
                System.out.println("Operation Result = " + operation2.makeOperation(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1))));
            }
        }

                            /*if(operation.getOperator().equals(stringOperator)){
                                operation.makeOperation();
                            }*/


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

        //System.out.println("Operation Result = " + operation.makeOperation());
        //visorText += buttons.get(finalI).getText() + "" + operation.makeOperation();
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
