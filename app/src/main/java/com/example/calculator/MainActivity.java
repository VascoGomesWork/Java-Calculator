package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.operations.Division;
import com.example.calculator.operations.Multiply;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.Addiction;
import com.example.calculator.operations.OperationTest;
import com.example.calculator.operations.Subtraction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    //Create an arrayList of Buttons and a String visorText
    ArrayList<Button> buttons = new ArrayList<>();
    String visorText = "";
    Operation operation;
    String operationString = "";
    int j = 0;
    int num = 0;
    char operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView visor = findViewById(R.id.visor);

        addButtonsToList();

        //Checks if any button has been pressed
        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Verifies if the content of the button is Clear, with if it is true goes to else
                    if (!buttons.get(finalI).getText().equals("C")) {

                        //Makes a String with the operation to be made
                        operationString += buttons.get(finalI).getText();
                        j++;

                        //If the key pressed is "=", returns the result of the operation
                        if(buttons.get(finalI).getText().equals("=")){

                            //Gets the substring without the "="
                            operationString = operationString.substring(0, j - 1);
                            //Gets the operator chosen by the user
                            operator = getOperationSign();

                            //TODO - Do not do with If's statements, use dynamic polymorphism somehow

                            String stringOperator = operator + "";

                            /*if(operation.getOperator().equals(stringOperator)){
                                operation.makeOperation()
                            }*/


                            if(stringOperator.equals("+")){
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
                                            }

                            System.out.println("Operation String = " + operationString);
                            System.out.println("Operation String Number 1 = " + operationString.substring(0, operationString.indexOf(operator)));
                            System.out.println("Operation String Number 2 = " + operationString.substring(operationString.indexOf(operator) + 1));

                            System.out.println("Operation Result = " + operation.makeOperation());
                            visorText += buttons.get(finalI).getText() + "" + operation.makeOperation();
                        }
                        else {
                            visorText += buttons.get(finalI).getText();
                            String text = "Button Pressed = " + buttons.get(finalI).getText();
                            System.out.println(text);
                        }
                            visor.setText(visorText);
                    }
                    else {
                        //Erases the content that was in the String visorText, sets the text in the visor to "",
                        //sets the operationString to "" and puts j = 0
                        visorText = new String();
                        visor.setText("");
                        operationString = "";
                        j = 0;
                    }
                }
            });
        }

    }

    private void addButtonsToList() {
        //Adds the buttons to the arrayList
        buttons.add(findViewById(R.id.btn1));
        buttons.add(findViewById(R.id.btn2));
        buttons.add(findViewById(R.id.btn3));
        buttons.add(findViewById(R.id.btn4));
        buttons.add(findViewById(R.id.btn5));
        buttons.add(findViewById(R.id.btn6));
        buttons.add(findViewById(R.id.btn7));
        buttons.add(findViewById(R.id.btn8));
        buttons.add(findViewById(R.id.btn9));
        buttons.add(findViewById(R.id.btn0));
        buttons.add(findViewById(R.id.addiction));
        buttons.add(findViewById(R.id.subtraction));
        buttons.add(findViewById(R.id.multiplication));
        buttons.add(findViewById(R.id.division));
        buttons.add(findViewById(R.id.point));
        buttons.add(findViewById(R.id.squareRoot));
        buttons.add(findViewById(R.id.cubicRoot));
        buttons.add(findViewById(R.id.equals));
        buttons.add(findViewById(R.id.clear));
    }

    private char getOperationSign() {
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