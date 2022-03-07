package com.example.calculator.operations;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.calculator.operations.OperationChooser;
@RunWith(AndroidJUnit4.class)
public class OperationChooserTest {

    @Test
    public void addTest(){

        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2+2=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("4.0", result);
    }

    @Test
    public void subtractTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2-2=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("0.0", result);
    }

    @Test
    public void multiplyTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2*2=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("4.0", result);
    }

    @Test
    public void divideTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "4-2=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("2.0", result);
    }

    @Test
    public void prioritizingOperationStartTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2*4-2+1=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("7.0", result);
    }

    @Test
    public void prioritizingOperationMiddleTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "1+4*2-2=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("7.0", result);
    }

    @Test
    public void prioritizingOperationEndTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "3-2+2*4=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("9.0", result);
    }

    @Test
    public void multiplePrioritizingOperationTest(){
        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2*3-2+2*4=";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("12.0", result);
    }

}