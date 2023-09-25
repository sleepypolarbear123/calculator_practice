package com.cs407.calculatorpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.button);
        subtractButton = findViewById(R.id.button2);
        multiplyButton = findViewById(R.id.button3);
        divideButton = findViewById(R.id.button4);

    }
    public void clickFunction1(View view){
        calculation("add");
    }

    public void clickFunction2(View view){
        calculation("subtract");
    }

    public void clickFunction3(View view){
        calculation("multiply");
    }

    public void clickFunction4(View view){
        calculation("divide");
    }
    private void calculation(String operation) {
        EditText firstNumberEditText = findViewById(R.id.editTextText);
        EditText secondNumberEditText = findViewById(R.id.editTextText2);
        if (TextUtils.isEmpty(firstNumberEditText.getText().toString()) || TextUtils.isEmpty(secondNumberEditText.getText().toString())) {
            Toast.makeText(this, "Please enter numbers.", Toast.LENGTH_SHORT).show();
            return;
        }

        float num1 = Integer.parseInt(firstNumberEditText.getText().toString().trim());
        float num2 = Integer.parseInt(secondNumberEditText.getText().toString().trim());
        float result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    Toast.makeText(this, "We cannot divide by zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        Intent intent = new Intent(MainActivity.this, result_display.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

}