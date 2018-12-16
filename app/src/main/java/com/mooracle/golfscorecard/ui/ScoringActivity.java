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
        editor.putInt("score1", holes[0].getScore());
        editor.putInt("score2", holes[1].getScore());
        editor.putInt("score3", holes[2].getScore());
        editor.putInt("score4", holes[3].getScore());
        editor.putInt("score5", holes[4].getScore());
        editor.putInt("score6", holes[5].getScore());
        editor.putInt("score7", holes[6].getScore());
        editor.putInt("score8", holes[7].getScore());
        editor.putInt("score9", holes[8].getScore());
        editor.putInt("score10", holes[9].getScore());
        editor.putInt("score11", holes[10].getScore());
        editor.putInt("score12", holes[11].getScore());
        editor.putInt("score13", holes[12].getScore());
        editor.putInt("score14", holes[13].getScore());
        editor.putInt("score15", holes[14].getScore());
        editor.putInt("score16", holes[15].getScore());
        editor.putInt("score17", holes[16].getScore());
        editor.putInt("score18", holes[17].getScore());
        editor.apply();
    }

    private Hole[] initiateHoles() {
        Hole[] initHoles = new Hole[18];
        // FIX THIS INITIALIZATION TO MATCH WITH 18 HOLES TO ACCOMMODATES GET INT FROM SHARED PREFERENCES
        initHoles[0] = new Hole(1, sharedPreferences.getInt("score1", 0));
        initHoles[1] = new Hole(2, sharedPreferences.getInt("score2", 0));
        initHoles[2] = new Hole(3, sharedPreferences.getInt("score3", 0));
        initHoles[3] = new Hole(4, sharedPreferences.getInt("score4", 0));
        initHoles[4] = new Hole(5, sharedPreferences.getInt("score5", 0));
        initHoles[5] = new Hole(6, sharedPreferences.getInt("score6", 0));
        initHoles[6] = new Hole(7, sharedPreferences.getInt("score7", 0));
        initHoles[7] = new Hole(8, sharedPreferences.getInt("score8", 0));
        initHoles[8] = new Hole(9, sharedPreferences.getInt("score9", 0));
        initHoles[9] = new Hole(10, sharedPreferences.getInt("score10", 0));
        initHoles[10] = new Hole(11, sharedPreferences.getInt("score11", 0));
        initHoles[11] = new Hole(12, sharedPreferences.getInt("score12", 0));
        initHoles[12] = new Hole(13, sharedPreferences.getInt("score13", 0));
        initHoles[13] = new Hole(14, sharedPreferences.getInt("score14", 0));
        initHoles[14] = new Hole(15, sharedPreferences.getInt("score15", 0));
        initHoles[15] = new Hole(16, sharedPreferences.getInt("score16", 0));
        initHoles[16] = new Hole(17, sharedPreferences.getInt("score17", 0));
        initHoles[17] = new Hole(18, sharedPreferences.getInt("score18", 0));
        return initHoles;
    }

}
