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

        //Choose the Operation to be made without having to make tons of If's statement
        //TODO - Check if the numbers introduced are double or not
        //Todo - Make Operation Preoritizing, meaby with a class that makes extend to multiplication and division
        String stringOperator = operator + "";
        try {
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

            System.out.println("Operation String = " + operationString);
            System.out.println("Operation String Number 1 = " + operationString.substring(0, operationString.indexOf(operator)));
            System.out.println("Operation String Number 2 = " + operationString.substring(operationString.indexOf(operator) + 1));


        } catch (Exception e) {
            System.out.println("Introduce the 2 values");
            operationResult = 0;
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

        return operationResult;
    }


    public boolean checkIfNumberIsInteger(String operationString){

        //Checks how many operation signs there are and add 1 to the result, to know how many numbers are to use in for cycle

        return false;
    }

    private char getOperationSign(String operationString) {
        char localOperator  = ' ';
        //Gets the operation sign
        for (int k = 0; k < operationString.length(); k++) {
            //Checks if the char at the position k is a ".", cause if it is skips it so it dosen't throw any errors
            if(operationString.charAt(k) != ('.')) {
                try {
                    num = Integer.parseInt(operationString.charAt(k) + "");
                } catch (Exception e) {
                    localOperator = operationString.charAt(k);
                }
            }
        }
        System.out.println("Operator = " + localOperator);
        return localOperator;
    }
}
