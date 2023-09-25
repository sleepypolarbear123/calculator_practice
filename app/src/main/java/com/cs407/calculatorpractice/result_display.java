package com.cs407.calculatorpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class result_display extends AppCompatActivity {
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);
        resultTextView = findViewById(R.id.textView);

        float result = getIntent().getFloatExtra("result", 0);
        resultTextView.setText(String.valueOf(result));
    }
}