package com.mooracle.golfscorecard.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.mooracle.golfscorecard.R;

public class MainActivity extends AppCompatActivity {
    public Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScoreActivity();
            }
        });
    }

    private void startScoreActivity() {
        //starting ScoringActivity
        Intent intent = new Intent(this, ScoringActivity.class);
        startActivity(intent);
    }
}
