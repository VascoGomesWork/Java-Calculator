package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.operations.OperationChooser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    //Create an arrayList of Buttons and a String visorText
    ArrayList<Button> buttons = new ArrayList<>();
    String visorText = "";
    OperationChooser operationChooser = new OperationChooser();
    String operationString = "";
    int j = 0;


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
                    System.out.println("J -> " + j);
                    //Verifies if the content of the button is Clear, with if it is true goes to else
                    if (!buttons.get(finalI).getText().equals("AC")) {
                        //Checks if button delete was pressed
                        if (buttons.get(finalI).getText().equals("")) {

                            System.out.println("Delete button pressed");
                            if (!operationString.isEmpty()) {
                                operationString = operationString.substring(0, operationString.length() - 1);
                                //Decrements J variable
                                j--;
                                System.out.println(operationString);
                                visorText = operationString;
                                //Updates Visor Text
                                visor.setText(visorText);
                            } else {
                                visorText = new String();
                                visor.setText("");
                                operationString = "";
                                j = 0;
                            }
                        } else {
                            //Makes a String with the operation to be made
                            operationString += buttons.get(finalI).getText();
                            j++;

                            //If the key pressed is "=", returns the result of the operation
                            if (buttons.get(finalI).getText().equals("=")) {
                                //Checks if the user is trying to divide by 0
                                if (!operationString.contains("/0")) {
                                    //Get From Operation Chooser Class the result of the Operation through Polymorphism
                                    //Checks if all numbers are Integer
                                    System.out.println("OPERATION STRING = " + operationString);
                                    String resultOperation = operationChooser.chooseOperation(operationString, j) + "";
                                    if (operationChooser.checkFinalResultIsInteger(resultOperation)) {
                                        //Converts the Result to Integer
                                        visorText += "=" + Math.round(Double.parseDouble(resultOperation));
                                    } else {
                                        //The Result Stays as a Double
                                        visorText += "=" + resultOperation;
                                    }
                                } else {
                                    visorText = operationString + "NaN";
                                    visor.setText(visorText);
                                    operationString = "";
                                    j = 0;
                                }
                            } else {
                                visorText += buttons.get(finalI).getText();
                                String text = "Button Pressed -> " + buttons.get(finalI).getText();
                                System.out.println(text);
                            }
                            visor.setText(visorText);
                        }
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

    //TODO - Insert Linear Layout
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
        buttons.add(findViewById(R.id.btn15));
    }
}