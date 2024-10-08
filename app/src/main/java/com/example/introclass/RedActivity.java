package com.example.introclass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RedActivity extends AppCompatActivity {
    Button btnRed,btnYellow, btnGreen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red);

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnYellow = findViewById(R.id.btnYellow);

        btnYellow.setOnClickListener(v -> {
            //navigate to yellow activity
            Intent yellowIntent = new Intent(this, YellowActivity.class);
            startActivity(yellowIntent);
        });

        btnGreen.setOnClickListener(v -> {
            //navigate to green activity
            Intent greenIntent = new Intent(this, GreenActivity.class);
            startActivity(greenIntent);
        });
    }
}
