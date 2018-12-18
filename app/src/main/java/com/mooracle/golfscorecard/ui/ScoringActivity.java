package com.mooracle.golfscorecard.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.mooracle.golfscorecard.R;
import com.mooracle.golfscorecard.adapter.HoleAdapter;
import com.mooracle.golfscorecard.model.Hole;

import java.util.Arrays;
import java.util.List;

public class ScoringActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "com.mooracle.golfscorecard.preferences";
    private Hole[] holes;
    private HoleAdapter adapter;
    // SET SHARED PREFERENCES
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);

        RecyclerView recyclerScore = findViewById(R.id.recyclerScore);
        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

        //initiating editor
        editor = sharedPreferences.edit();
        editor.apply();


        //initiate the Hole array:
        holes = initiateHoles();

        //make holes into list:
        List<Hole> holeList = Arrays.asList(holes);

        //set adapter

        adapter = new HoleAdapter(holeList);
        recyclerScore.setAdapter(adapter);

        //optimize recycler view
        recyclerScore.setHasFixedSize(true);
        recyclerScore.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        //set layout manager and bind into recyclerScore
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerScore.setLayoutManager(layoutManager);

        // : DELETE BUTTON CLEAR TO CLEAR ALL SHARED PREFERENCES AND RELOAD THE ACTIVITY.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //set the menu to inflate the Action bar and subtitute the clear score button!!
        //we can delete the clear scores button after this is set!
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.score_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.resetScore) {//put out an Alert that this will erase all of the scores
            //Alert dialog is a static class it can be called directly with no initialization and addressing
            new AlertDialog.Builder(this)
                    .setTitle("WARNING!")
                    .setMessage("This Will Reset All of Your Scores!, Are You Sure?")
                    .setIcon(R.drawable.reset_icon)
                    .setPositiveButton(R.string.alert_yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //if the user press Yes reset all scores:
                            resetScores(adapter);
                        }
                    })
                    .setNegativeButton(R.string.alert_no, null) //if the user press no don't do anything
                    .show(); //show the alert dialog
        }
        return super.onOptionsItemSelected(item);
    }

    private void resetScores(HoleAdapter adapter) {
        //this method handles the resetting of all scores:
        for (Hole hole : holes){
            hole.setScore(0);
        }

        //clear the data inside editor to save memory:
        editor.clear();
        editor.apply();

        //switch from refresh the whole activity to just notify the adapter: <- to save memory
        adapter.notifyDataSetChanged();
    }

    // OVERRIDE ON PAUSE METHOD AND PUT ALL INT SCORE through editor (I initialize it here)
    @Override
    protected void onPause() {
        super.onPause();

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
