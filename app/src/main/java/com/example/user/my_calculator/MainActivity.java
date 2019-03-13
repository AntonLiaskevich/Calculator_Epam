package com.example.user.my_calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {

    Button btnNumber0;
    Button btnNumber1;
    Button btnNumber2;
    Button btnNumber3;
    Button btnNumber4;
    Button btnNumber5;
    Button btnNumber6;
    Button btnNumber7;
    Button btnNumber8;
    Button btnNumber9;

    TextView txtResult;

    EditText edtInput;

    Button btnCE;
    Button btnC;
    Button btnDelete;

    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;

    Button btnDot;
    Button btnResult;

    double val1=NaN;
    double val2;
    String ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNumber0 = findViewById(R.id.btnNumber0);
        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        btnNumber3 = findViewById(R.id.btnNumber3);
        btnNumber4 = findViewById(R.id.btnNumber4);
        btnNumber5 = findViewById(R.id.btnNumber5);
        btnNumber6 = findViewById(R.id.btnNumber6);
        btnNumber7 = findViewById(R.id.btnNumber7);
        btnNumber8 = findViewById(R.id.btnNumber8);
        btnNumber9 = findViewById(R.id.btnNumber9);

        txtResult = findViewById(R.id.txtResult);

        edtInput = findViewById(R.id.edtInput);

        btnCE = findViewById(R.id.btnCE);
        btnC = findViewById(R.id.btnC);
        btnDelete = findViewById(R.id.btnDelete);

        btnAdd = findViewById(R.id.btnNumberAdd);
        btnSub = findViewById(R.id.btnNumberSub);
        btnMul = findViewById(R.id.btnNumberMul);
        btnDiv = findViewById(R.id.btnNumberDiv);

        btnDot = findViewById(R.id.btnDot);
        btnResult = findViewById(R.id.btnResult);

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtInput.setText(null);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = NaN;
                txtResult.setText(null);
                edtInput.setText(null);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = edtInput.getText().toString();
                if(number.length() > 0){
                    number = number.substring(0, number.length() - 1);
                }
                edtInput.setText(number);
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                ACTION = "+";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1 + val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " + ");
                edtInput.setText(null);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                ACTION = "-";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1 - val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " - ");
                edtInput.setText(null);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                ACTION = "*";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1 * val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " * ");
                edtInput.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                ACTION = "/";
                if(!Double.isNaN(val1)){
                    val2 = Double.parseDouble(edtInput.getText().toString());
                    val1 = val1/val2;
                } else {
                    val1 = Double.parseDouble(edtInput.getText().toString());
                }

                txtResult.setText(val1 + " / ");
                edtInput.setText(null);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ACTION != null && ACTION.equals("+")){
                    double result = val1 + Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                } else if(ACTION != null && ACTION.equals("-")){
                    double result = val1 - Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                } else if(ACTION != null && ACTION.equals("*")){
                    double result = val1 * Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                } else if(ACTION != null && ACTION.equals("/")){
                    double result = val1 / Double.parseDouble(edtInput.getText().toString());
                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(result));
                }

                ACTION = null;
                val1 = NaN;
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "0");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "1");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "2");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "3");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "4");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "5");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "6");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "7");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "8");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + "9");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edtInput.setText(edtInput.getText() + ".");
                edtInput.setSelection(edtInput.getText().length());
            }
        });

    }
}
