package com.example.user.my_calculator;

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

    private int action;
    private double firstNumber = 0;
    private boolean isFirstNumber = true;
    private boolean doesFirstNumberContainEqully = true;

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
        doesFirstNumberContainEqully = true;
    }

    public void onDotClick(View view) {
        if(!(numberInput.getText().toString().contains(".")) & isFirstNumber) {
            isFirstNumber = false;
            numberInput.setText(numberInput.getText() + ".");
            numberInput.setSelection(numberInput.getText().length());
        }
    }

    public void onMathematicalSignClick(View view) {
        Button button = (Button) view;

        if(isFirstNumber) {
            action = button.getId();
            isFirstNumber = false;
            if (!Double.isNaN(firstNumber)) {
                switch (action) {
                    case R.id.buttonPlus:
                        firstNumber = firstNumber + Double.parseDouble(numberInput.getText().toString());

                        break;
                    case R.id.buttonMinus:
                        firstNumber = firstNumber - Double.parseDouble(numberInput.getText().toString());

                        break;
                    case R.id.buttonMultiplication:
                        firstNumber = firstNumber * Double.parseDouble(numberInput.getText().toString());

                        break;
                    case R.id.buttonDivision:
                        firstNumber = firstNumber / Double.parseDouble(numberInput.getText().toString());

                        break;
                }
            } else {
                firstNumber = Double.parseDouble(numberInput.getText().toString());
            }

            resultOfOperation.setText(firstNumber + button.getText().toString());
            numberInput.setText(null);
        }
    }

    public void onResultClick(View view) {

        if(isFirstNumber & doesFirstNumberContainEqully) {
            doesFirstNumberContainEqully = false;
            switch (action){
                case R.id.buttonPlus:
                    double result = firstNumber + Double.parseDouble(numberInput.getText().toString());
                    resultOfOperation.setText(null);
                    numberInput.setText(String.valueOf(result));

                    break;
                case R.id.buttonMinus:
                    result = firstNumber - Double.parseDouble(numberInput.getText().toString());
                    resultOfOperation.setText(null);
                    numberInput.setText(String.valueOf(result));

                    break;
                case R.id.buttonMultiplication:
                    result = firstNumber * Double.parseDouble(numberInput.getText().toString());
                    resultOfOperation.setText(null);
                    numberInput.setText(String.valueOf(result));

                    break;
                case R.id.buttonDivision:
                    result = firstNumber / Double.parseDouble(numberInput.getText().toString());
                    resultOfOperation.setText(null);
                    numberInput.setText(String.valueOf(result));

                    break;
            }

            firstNumber = NaN;
            numberInput.setSelection(numberInput.getText().length());
        }
    }
}
