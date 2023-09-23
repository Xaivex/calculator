package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNumberEditText;
    EditText secondNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.editText);
        secondNumberEditText = findViewById(R.id.editText2);
    }

    public void calculate(View view) {
        double num1 = Double.parseDouble(firstNumberEditText.getText().toString());
        double num2 = Double.parseDouble(secondNumberEditText.getText().toString());
        double result = 0.0;

        if (view.getId() == R.id.button2) { // Addition
            result = num1 + num2;
        } else if (view.getId() == R.id.button3) { // Subtraction
            result = num1 - num2;
        } else if (view.getId() == R.id.button4) { // Multiplication
            result = num1 * num2;
        } else if (view.getId() == R.id.button5) { // Division
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                // Handle division by zero error
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Pass the result to the output activity
        Intent intent = new Intent(this, output.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}