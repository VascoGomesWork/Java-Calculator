package com.example.calculator;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.calculator.operations.OperationChooser;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.calculator", appContext.getPackageName());
    }

    /*@Test
    public void addTest(){

        OperationChooser operationChooser = new OperationChooser();
        String operationString = "2+2";
        String result = "" + operationChooser.chooseOperation(operationString, operationString.length());
        assertEquals("4", result);
    }*/

    @Test
    public void test(){
        assertEquals("1", "1");
    }
}