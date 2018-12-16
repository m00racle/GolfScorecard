package com.mooracle.golfscorecard.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;
import com.mooracle.golfscorecard.R;
import com.mooracle.golfscorecard.adapter.HoleAdapter;
import com.mooracle.golfscorecard.model.Hole;

import java.util.Arrays;
import java.util.List;

public class ScoringActivity extends AppCompatActivity {
    private Button clearButton;
    private RecyclerView recyclerScore;
    private HoleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        clearButton = findViewById(R.id.clearButton);
        recyclerScore = findViewById(R.id.recyclerScore);

        //initiate the Hole array:
        Hole[] holes = initiateHoles(18);

        //make holes into list:
        List<Hole> holeList = Arrays.asList(holes);

        //set adapter
        adapter = new HoleAdapter(holeList);
        recyclerScore.setAdapter(adapter);

        //set layout manager and bind into recyclerScore
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerScore.setLayoutManager(layoutManager);
    }

    private Hole[] initiateHoles(int numHole) {
        Hole[] holes = new Hole[numHole];
        for (int i = 0; i < numHole; i++){
            holes[i] = new Hole(i+1, 0);
        }
        return holes;
    }

}
