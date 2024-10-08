package com.example.introclass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class YellowActivity extends AppCompatActivity {
    Button btnRed,btnYellow, btnGreen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yellow);

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnYellow = findViewById(R.id.btnYellow);

        btnRed.setOnClickListener(v -> {
            //navigate to red activity
            Intent redIntent = new Intent(this, RedActivity.class);
            startActivity(redIntent);
        });

        btnGreen.setOnClickListener(v -> {
            //navigate to green activity
            Intent greenIntent = new Intent(this, GreenActivity.class);
            startActivity(greenIntent);
        });
    }
}
