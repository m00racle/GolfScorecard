package com.mooracle.golfscorecard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import com.mooracle.golfscorecard.R;
import com.mooracle.golfscorecard.model.Hole;

public class ScoringActivity extends AppCompatActivity {
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        clearButton = findViewById(R.id.clearButton);

        //initiate the Hole array:
        Hole[] holes = initiateHoles(18);

        //test holes initiations:
        /*String checkHole = "Hole set: ";
        for (Hole hole : holes){
            checkHole = checkHole + String.valueOf(hole.getHoleNumber());
        }
        Toast.makeText(ScoringActivity.this,checkHole, Toast.LENGTH_LONG).show();*/
    }

    private Hole[] initiateHoles(int numHole) {
        Hole[] holes = new Hole[numHole];
        for (int i = 0; i < numHole; i++){
            holes[i] = new Hole(i+1, 0);
        }
        return holes;
    }

}
