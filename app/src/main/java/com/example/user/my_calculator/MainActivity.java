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

    private TextView txtResult;
    private EditText edtInput;

    private double firstNumber = NaN;
    private double secondNumber;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
        edtInput = findViewById(R.id.edtInput);
    }

    public void onCEClick(View view) {
        edtInput.setText(null);
    }

    public void onCClick(View view) {
        firstNumber = NaN;
        txtResult.setText(null);
        edtInput.setText(null);
    }

    public void onDelClick(View view) {
        String number = edtInput.getText().toString();
        if (number.length() > 0) {
            number = number.substring(0, number.length() - 1);
        }
        edtInput.setText(number);
        edtInput.setSelection(edtInput.getText().length());
    }

    @SuppressLint("SetTextI18n")
    public void onDigitClick(View view) {
        Button digit = (Button) view;

        edtInput.setText(edtInput.getText() + digit.getText().toString());
        edtInput.setSelection(edtInput.getText().length());
    }

    @SuppressLint("SetTextI18n")
    public void onAddClick(View view) {
        action = "+";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(edtInput.getText().toString());
            firstNumber = firstNumber + secondNumber;
        } else {
            firstNumber = Double.parseDouble(edtInput.getText().toString());
        }

        txtResult.setText(firstNumber + " + ");
        edtInput.setText(null);
    }

    @SuppressLint("SetTextI18n")
    public void onSubClick(View view) {
        action = "-";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(edtInput.getText().toString());
            firstNumber = firstNumber - secondNumber;
        } else {
            firstNumber = Double.parseDouble(edtInput.getText().toString());
        }

        txtResult.setText(firstNumber + " - ");
        edtInput.setText(null);
    }

    @SuppressLint("SetTextI18n")
    public void onMulClick(View view) {
        action = "*";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(edtInput.getText().toString());
            firstNumber = firstNumber * secondNumber;
        } else {
            firstNumber = Double.parseDouble(edtInput.getText().toString());
        }

        txtResult.setText(firstNumber + " * ");
        edtInput.setText(null);
    }

    @SuppressLint("SetTextI18n")
    public void onDotClick(View view) {
        edtInput.setText(edtInput.getText() + ".");
        edtInput.setSelection(edtInput.getText().length());
    }

    @SuppressLint("SetTextI18n")
    public void onDivClick(View view) {
        action = "/";
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(edtInput.getText().toString());
            firstNumber = firstNumber / secondNumber;
        } else {
            firstNumber = Double.parseDouble(edtInput.getText().toString());
        }

        txtResult.setText(firstNumber + " / ");
        edtInput.setText(null);
    }

    public void onResultClick(View view) {
        if (action != null && action.equals("+")) {
            double result = firstNumber + Double.parseDouble(edtInput.getText().toString());
            txtResult.setText(null);
            edtInput.setText(String.valueOf(result));
        } else if (action != null && action.equals("-")) {
            double result = firstNumber - Double.parseDouble(edtInput.getText().toString());
            txtResult.setText(null);
            edtInput.setText(String.valueOf(result));
        } else if (action != null && action.equals("*")) {
            double result = firstNumber * Double.parseDouble(edtInput.getText().toString());
            txtResult.setText(null);
            edtInput.setText(String.valueOf(result));
        } else if (action != null && action.equals("/")) {
            double result = firstNumber / Double.parseDouble(edtInput.getText().toString());
            txtResult.setText(null);
            edtInput.setText(String.valueOf(result));
        }

        action = null;
        firstNumber = NaN;
        edtInput.setSelection(edtInput.getText().length());
    }
}
