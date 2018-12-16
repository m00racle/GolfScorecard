package com.mooracle.golfscorecard.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mooracle.golfscorecard.R;
import com.mooracle.golfscorecard.model.Hole;

import java.util.List;

public class HoleAdapter extends RecyclerView.Adapter<HoleAdapter.MyViewHolder> {
    //The list of Holes
    private List<Hole> holes;

    //constructor


    public HoleAdapter(List<Hole> holes) {
        this.holes = holes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //binding to view holder
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.score_list, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int index) {
        final Hole hole = holes.get(index);
        holder.holeNumberText.setText(String.valueOf(hole.getHoleNumber()));
        holder.scoreText.setText(String.valueOf(hole.getScore()));

        //set Add button action:
        holder.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hole.setScore(hole.getScore() + 1);
                holder.scoreText.setText(String.valueOf(hole.getScore()));
            }
        });

        //set subtract button action:
        holder.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hole.getScore() > 0){
                    hole.setScore(hole.getScore() - 1);
                    holder.scoreText.setText(String.valueOf(hole.getScore()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return holes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //view list:
        TextView scoreLabel, scoreText, holeNumberLabel, holeNumberText;
        Button buttonSubtract, buttonAdd;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //binding view id
            scoreLabel = itemView.findViewById(R.id.scoreLabel);
            scoreText = itemView.findViewById(R.id.scoreText);
            holeNumberLabel = itemView.findViewById(R.id.holeNumberLabel);
            holeNumberText = itemView.findViewById(R.id.holeNumberText);
            buttonAdd = itemView.findViewById(R.id.buttonAdd);
            buttonSubtract = itemView.findViewById(R.id.buttonSubstract);
        }
    }
}
