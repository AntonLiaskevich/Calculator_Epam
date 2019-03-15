package com.example.user.my_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {

    private TextView resultOfOperation;
    private EditText numberInput;

    private double firstNumber = 0;
    private double secondNumber;
    private String action;
    private boolean isFirstNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultOfOperation = findViewById(R.id.resultOfOperation);
        numberInput = findViewById(R.id.numberInput);
    }

    public void onCEClick(View view) {
        numberInput.setText(null);
    }

    public void onCClick(View view) {
        firstNumber = NaN;
        resultOfOperation.setText(null);
        numberInput.setText(null);
    }

    public void onDelClick(View view) {
        String number = numberInput.getText().toString();
        if (number.length() > 0) {
            number = number.substring(0, number.length() - 1);
        }
        numberInput.setText(number);
        numberInput.setSelection(numberInput.getText().length());
    }

    public void onDigitClick(View view) {
        Button digit = (Button) view;

        numberInput.setText(numberInput.getText() + digit.getText().toString());
        numberInput.setSelection(numberInput.getText().length());
        isFirstNumber = true;
    }

    public void onAddClick(View view) {
        if(isFirstNumber) {
            isFirstNumber = false;
            action = "+";
            if (!Double.isNaN(firstNumber)) {
                /*secondNumber = Double.parseDouble(numberInput.getText().toString());*/
                firstNumber = firstNumber + Double.parseDouble(numberInput.getText().toString());
            } else {
                firstNumber = Double.parseDouble(numberInput.getText().toString());
            }

            resultOfOperation.setText(firstNumber + " + ");
            numberInput.setText(null);
        }
    }

    public void onSubClick(View view) {
        action = "-";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(numberInput.getText().toString());
            firstNumber = firstNumber - secondNumber;
        } else {
            firstNumber = Double.parseDouble(numberInput.getText().toString());
        }

        resultOfOperation.setText(firstNumber + " - ");
        numberInput.setText(null);
    }

    public void onMulClick(View view) {
        action = "*";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(numberInput.getText().toString());
            firstNumber = firstNumber * secondNumber;
        } else {
            firstNumber = Double.parseDouble(numberInput.getText().toString());
        }

        resultOfOperation.setText(firstNumber + " * ");
        numberInput.setText(null);
    }

    public void onDotClick(View view) {
        numberInput.setText(numberInput.getText() + ".");
        numberInput.setSelection(numberInput.getText().length());
    }

    public void onDivClick(View view) {
        action = "/";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(numberInput.getText().toString());
            firstNumber = firstNumber / secondNumber;
        } else {
            firstNumber = Double.parseDouble(numberInput.getText().toString());
        }

        resultOfOperation.setText(firstNumber + " / ");
        numberInput.setText(null);
    }

    public void onResultClick(View view) {
        if (action != null && action.equals("+")) {
            double result = firstNumber + Double.parseDouble(numberInput.getText().toString());
            resultOfOperation.setText(null);
            numberInput.setText(String.valueOf(result));
        } else if (action != null && action.equals("-")) {
            double result = firstNumber - Double.parseDouble(numberInput.getText().toString());
            resultOfOperation.setText(null);
            numberInput.setText(String.valueOf(result));
        } else if (action != null && action.equals("*")) {
            double result = firstNumber * Double.parseDouble(numberInput.getText().toString());
            resultOfOperation.setText(null);
            numberInput.setText(String.valueOf(result));
        } else if (action != null && action.equals("/")) {
            double result = firstNumber / Double.parseDouble(numberInput.getText().toString());
            resultOfOperation.setText(null);
            numberInput.setText(String.valueOf(result));
        }

        action = null;
        firstNumber = NaN;
        numberInput.setSelection(numberInput.getText().length());
    }
}
