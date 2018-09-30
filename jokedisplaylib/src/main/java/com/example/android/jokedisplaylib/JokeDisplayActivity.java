package com.example.android.jokedisplaylib;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String INTENT_KEY_JOKE ="joke";

    TextView JokeTV;
    ProgressBar jokePB;
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Intent intent = getIntent();
        joke = intent.getStringExtra(INTENT_KEY_JOKE);
        JokeTV = findViewById(R.id.joke_tv);
        jokePB = findViewById(R.id.joke_pb);
        jokePB.setVisibility(View.VISIBLE);
        if (joke != null && joke.length() != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    jokePB.setVisibility(View.GONE);
                    JokeTV.setText(joke);
                }
            }, 1000);

        } else {
            String errorMsg= getResources().getString(R.string.error_message);
            JokeTV.setText(errorMsg);
        }
    }
}
