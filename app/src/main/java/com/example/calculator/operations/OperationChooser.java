package com.example.calculator.operations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class OperationChooser {

    char operator;
    double operationResult = 0;
    int num = 0;


    /**
     * @Resume :
     * @param operationString
     * @param j
     * @return
     */
    public double chooseOperation(String operationString, int j){
        //Gets the substring without the "=" sign
        System.out.println("Operation String Choose Operation = " + operationString);
        operationString = operationString.substring(0, j - 1);
        //Gets the operator chosen by the user
        operator = getOperationSign(operationString);

        //Choose the Operation to be made without having to make tons of If's statement
        String stringOperator = operator + "";
        try {

            //Gets the Operation List with all things configured
            List<Operation> operationList = operationList(operationString);

            for (Operation operation : operationList) {
                if(operation.getOperator().equals(stringOperator)){
                    operationResult = operation.makeOperation();
                    break;
                }
            }
        } catch (Exception e) {
            //System.out.println("Introduce the 2 values");
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

    /**
     * @Resume :
     * @param operationString
     * @return
     */
    public List<Operation> operationList(String operationString){
        //Checks if operationString has "=" sign and remove it if so
        operationString = substringUntilChar(operationString, "=");
        List<Operation> operationList = new ArrayList<>();

        //Goes to catch if the String has more than 2 numbers to separate the String and make the operation separately
        try {
            operationList = fufillList(operationString);

        } catch (Exception e){
            //2+2+3
            System.out.println("Tem mais de 2 números");
            System.out.println("Operation String After Catch = " + operationString);

            //Checks if the String has a prioritizing operation
            //It is only worth to do this in an operation that contains more than 2 numbers
            //Because doing 2*4 = 8 and doing 2+2*4 = 2*4+2 = 8+2 = 10 it's different
            //What Im' going to do is to solve the prioritizing operation first and then replace it in operationString
            operationString = solvePrioritizingOperations(operationString);

            //Separates the String -> 2+2
            String operationSubstring = separateString(operationString);
            //4+3
            //operationSubstring.length() + 1 -> Gets the length of the substring to be able to do the operation

            double subOperation = chooseOperation(operationSubstring, operationSubstring.length() + 1);
            String subOperationString = subOperation + "";

            System.out.println("SUBOPERATION = " + subOperation);
            String finalOperation = operationString.replace(operationString.substring(operationString.indexOf(operationString.charAt(0)), operationString.lastIndexOf(getOperationSign(operationString))), subOperationString.contains(".0") ? Math.round(subOperation) + "" : subOperation/*subOperation*/ + "");
            System.out.println("FINAL OPERATION = " + finalOperation);
            chooseOperation(finalOperation, finalOperation.length() + 1);
        }

        return operationList;
    }

    /**
     * @Resume : Function that solves the prioritizing operation
     * @param operationString

     * @return : String operationString
     */
    private String solvePrioritizingOperations(String operationString) {
        //Gets a List with the prioritizing operations
        List<String> prioritizingOperators = getPrioritizingOperators();

        for (String prioritizingOperation : prioritizingOperators){
            if(operationString.contains(prioritizingOperation)){
                //Gets the numbers that are included on the prioritized operation
                String prioritizingOperationSubstring = "";
                try {
                    prioritizingOperationSubstring = operationString.substring(operationString.indexOf(operator) + 1, operationString.indexOf(prioritizingOperation) + 2);
                } catch (Exception e) {
                    prioritizingOperationSubstring = operationString.substring(operationString.indexOf(prioritizingOperation) - 1, operationString.indexOf(prioritizingOperation) + 2); }
                System.out.println("Prioritizing Operation = " + prioritizingOperationSubstring);
                //Makes the prioritizing operation
                double prioritizeOperation = chooseOperation(prioritizingOperationSubstring, prioritizingOperationSubstring.length() + 1);
                operationString = operationString.replace(prioritizingOperationSubstring, prioritizeOperation + "");
                System.out.println("Operation String Modified = " + operationString);
                //For this not giving error in operations like 1+2*3/2, it has to be aplied an if
                //Adding 0 does not change the result of the operation, but it dosen't crash the program in the states ahead
                if(operationString.contains(prioritizingOperation)){
                    operationString = solvePrioritizingOperations(operationString);
                    System.out.println("Operation String inside if = " + operationString);
                }
                operationString = operationString + "+0";
                }
        }

        return operationString;
    }

    /**
     * @Resume : Function that gets a List with the prioritizing operations
     * @return : List prioritizingOperationList
     */
    private List<String> getPrioritizingOperators() {
        List<Operation> operationList = fufillList("0+0");
        List<String> prioritizingOperationList = new ArrayList<>();
        for (Operation operation : operationList) {
            if (operation.operationPrioritizing() == 1) {
                prioritizingOperationList.add(operation.getOperator());
            }
        }
        System.out.println("Prioritizing List = " + prioritizingOperationList);
        return prioritizingOperationList;
    }

    /**
     * @Resume : Function that fufills a List of operations
     * @param operationString
     * @return : operationList
     */
    private List<Operation> fufillList(String operationString) {
        List<Operation> operationList = new ArrayList<>();

        operator = getOperationSign(operationString);
        Operation addiction = new Addiction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
        Operation subtraction = new Subtraction(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
        Operation multiply = new Multiply(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));
        Operation division = new Division(Double.parseDouble(operationString.substring(0, operationString.indexOf(operator))), Double.parseDouble(operationString.substring(operationString.indexOf(operator) + 1)));

        operationList.add(addiction);
        operationList.add(subtraction);
        operationList.add(multiply);
        operationList.add(division);

        return operationList;
    }

    /**
     * @Resume : Function that separates a operationString -> 1+2+3 to 1+2
     * @param operationString
     * @return : A substring of the original operationString
     */
    private String separateString(String operationString) {

        return operationString.substring(0, operationString.lastIndexOf(getOperationSign(operationString)));
    }

    /**
     * @Resume :
     * @param operationString
     * @param string
     * @return
     */
    private String substringUntilChar(String operationString, String string){
        if(operationString.contains(string)){
            operationString = operationString.substring(0, operationString.indexOf(string));
        }
        return operationString;
    }


    /**
     * @Resume : Function that gets the operation sign of the operationString
     * @param operationString
     * @return : char operator
     */
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

    /**
     * @Resume : Function that checks if the values after the "." are all 0, adding to the variable num
     * @param resultOperation
     * @return true in case of the num == 0, false instead
     */
    public boolean checkFinalResultIsInteger(String resultOperation) {
        System.out.println("Operation String Function Test = " + resultOperation);
            char[] decimalPartOperation = resultOperation.substring(resultOperation.indexOf(".") + 1).toCharArray();
            int num = 0;
            for (char decimal : decimalPartOperation) {
                System.out.println("Decimal = " + decimal);
                num += Integer.parseInt(decimal + "");
            }
            System.out.println("Num = " + num);
            if(num == 0){
                return true;
            }
            return false;
    }
}
