package com.example.introclass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);

        /** Click event handler setOnClickListener. Listens for a button click
         *
         * **/
        btnLogin.setOnClickListener(v -> {
            /** Shared preferences object that works with the one in MainActivity
             * Refer to MainActivity for discussion.
             * In this bit of code, if our Login Button is clicked,
             * we will store the username that's provided and display it in the MainActivity.
             * How do we do this?
             *
             * We get a SharedPreferences object and pass it using the name "RoboPrefs"
             *
             *
             * **/
            SharedPreferences storePreferences = getSharedPreferences("RoboPrefs",MODE_PRIVATE);
            SharedPreferences.Editor sharedPrefEditor = storePreferences.edit();

            sharedPrefEditor.putString("username",edtUsername.getText().toString());
            sharedPrefEditor.apply();

            /** An intent is a message object that usually specifies an action from
             * one activity to the next.
             *
             * With this intent, the action is to move from the LoginActivity to the MainActivity
             * MainActivity is the componentName that satisfies our Explicit intent
             * (the type of intent you see below is called an explicit intent (because
             * you specify which component you want))
             *
             * **/
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            /**Toast
            * We use a toast to display messages to the user.
             * You need to provide "Context" -> the activity the toast will show up on
             *  text-> the text the toast will display
             *  length -> the duration you want the toast to be displayed for (long /short)
             *  lastly, you use the method show(), to display it to the user
            **/
            Toast.makeText(this, "Login Successful",Toast.LENGTH_LONG).show();

        });

    }
}
