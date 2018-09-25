package com.example.android.jokedisplaylib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {


    TextView JokeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");
        JokeTV = findViewById(R.id.joke_tv);
        if (joke != null && joke.length() != 0) {
            JokeTV.setText(joke);
        }
    }
}
