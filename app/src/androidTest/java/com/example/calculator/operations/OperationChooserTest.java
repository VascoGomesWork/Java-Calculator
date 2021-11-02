package com.example.calculator.operations;

import junit.framework.TestCase;

import org.junit.Test;

public class OperationChooserTest extends TestCase {

    @Test
    public void addTest(){

        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2+2";
        double result = operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals(4.0, result);
    }

}