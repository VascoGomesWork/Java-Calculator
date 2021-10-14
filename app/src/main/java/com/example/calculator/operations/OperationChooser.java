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
        //Todo - Make Operation Preoritizing, meaby with a class that makes extend to multiplication and division
        String stringOperator = operator + "";
        try {

            List<Operation> operationList = operationList(operationString);

            for (Operation operation : operationList) {
                if(operation.getOperator().equals(stringOperator)){
                    operationResult = operation.makeOperation();
                }
            }
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

    public List<Operation> operationList(String operationString){
        //Checks if operationString has "=" sign and remove it if so
        operationString = checkIfStringContainsChar(operationString, "=");
        List<Operation> operationList = new ArrayList<>();

        //Goes to cath if the String has more than 2 numbers to separate the String and make the operation separately
        try {
            operator = getOperationSign(operationString);
            Operation addiction = new Addiction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
            Operation subtraction = new Subtraction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
            Operation multiply = new Multiply(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
            Operation division = new Division(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));

            operationList.add(addiction);
            operationList.add(subtraction);
            operationList.add(multiply);
            operationList.add(division);

        } catch (Exception e){
            //2+2+3
            System.out.println("Tem mais de 2 números");
            // Separates the String -> 2+2
            String operationSubstring = separateString(operationString);
            //4+3
            //operationSubstring.length() + 1 -> Gets the length of the substring to be able to do the operation

            double subOperation = chooseOperation(operationSubstring, operationSubstring.length() + 1);
            String subOperationString = chooseOperation(operationSubstring, operationSubstring.length() + 1) + "";

            System.out.println("SUBOPERATION = " + subOperation);
            String finalOperation = operationString.replace(operationString.substring(operationString.indexOf(operationString.charAt(0)), operationString.lastIndexOf(getOperationSign(operationString))), subOperationString.contains(".0") ? Math.round(subOperation) + "" : subOperation/*subOperation*/ + "");
            System.out.println("FINAL OPERATION = " + finalOperation);
            chooseOperation(finalOperation, finalOperation.length() + 1);
        }

        return operationList;
    }

    private String separateString(String operationString) {
        return operationString.substring(0, operationString.lastIndexOf(getOperationSign(operationString)));
    }

    private String checkIfStringContainsChar(String operationString, String string){
        if(operationString.contains(string)){
            operationString = operationString.substring(0, operationString.indexOf(string));
        }
        return operationString;
    }

    public boolean checkIfNumberIsInteger(String operationString){
        //Check if the numbers introduced are double or not
        operationString = checkIfStringContainsChar(operationString, "=");
        for (int i = 0; i < operationString.length(); i++) {
            for (Operation operation : operationList(operationString)) {
                if (!(operationString.charAt(i) + "").equals(operation.getOperator())) {
                    System.out.println(operationString);
                    try{
                        /*System.out.println("Value 1 = " + Integer.parseInt(operationString.substring(0, operationString.indexOf(operator))));
                        System.out.println("Values 2 = " + Integer.parseInt(operationString.substring(operationString.indexOf(operator) + 1)));*/
                        Integer.parseInt(operationString.substring(0, operationString.indexOf(operator)));
                        Integer.parseInt(operationString.substring(operationString.indexOf(operator) + 1));
                        return true;
                    }catch (Exception e){
                        System.out.println("Não são valores inteiros");
                    }
                }
            }
        }
        return false;
    }

    private char getOperationSign(String operationString) {
        char localOperator  = ' ';
        //Gets the operation sign
        for (int k = 0; k < operationString.length(); k++) {
            //Checks if the char at the position k is a ".", cause if it is skips it so it does not throw any errors
            if(operationString.charAt(k) != ('.')) {
                try {
                    num = Integer.parseInt(operationString.charAt(k) + "");
                } catch (Exception e) {
                    localOperator = operationString.charAt(k);
                }
            }
        }
        return localOperator;
    }
}
