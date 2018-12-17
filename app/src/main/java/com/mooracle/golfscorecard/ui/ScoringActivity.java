package com.mooracle.golfscorecard.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.mooracle.golfscorecard.R;
import com.mooracle.golfscorecard.adapter.HoleAdapter;
import com.mooracle.golfscorecard.model.Hole;

import java.util.Arrays;
import java.util.List;

public class ScoringActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "com.mooracle.golfscorecard.preferences";
    private Hole[] holes;
    // SET SHARED PREFERENCES
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        Button clearButton = findViewById(R.id.clearButton);
        RecyclerView recyclerScore = findViewById(R.id.recyclerScore);
        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);


        //initiate the Hole array:
        holes = initiateHoles();

        //make holes into list:
        List<Hole> holeList = Arrays.asList(holes);

        //set adapter
        HoleAdapter adapter = new HoleAdapter(holeList);
        recyclerScore.setAdapter(adapter);

        //optimize recycler view
        recyclerScore.setHasFixedSize(true);
        recyclerScore.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        //set layout manager and bind into recyclerScore
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerScore.setLayoutManager(layoutManager);

        // BUTTON CLEAR TO CLEAR ALL SHARED PREFERENCES AND RELOAD THE ACTIVITY.
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Hole hole : holes){
                    hole.setScore(0);
                }
                restartActivity();
            }
        });
    }

    private void restartActivity() {
        finish();
        startActivity(getIntent());
    }

    // OVERRIDE ON PAUSE METHOD AND PUT ALL INT SCORE through editor (I initialize it here)
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // iterate all editor put int:
        for (int i = 0; i < 18; i++){
            String name = "score" + (i + 1);
            editor.putInt(name, holes[i].getScore());
        }

        // apply editor changes:
        editor.apply();
    }

    private Hole[] initiateHoles() {
        Hole[] initHoles = new Hole[18];

        // FIX THIS INITIALIZATION TO MATCH WITH 18 HOLES TO ACCOMMODATES GET INT FROM SHARED PREFERENCES
        for (int i = 0; i < 18; i++){
            String name = "score" + (i + 1);
            initHoles[i] = new Hole(i + 1, sharedPreferences.getInt(name, 0));
        }

        //return the List of Hole
        return initHoles;
    }

}
