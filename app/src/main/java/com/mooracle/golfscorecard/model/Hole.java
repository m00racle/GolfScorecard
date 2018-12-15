package com.mooracle.golfscorecard.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Hole implements Parcelable {
    private int holeNumber;
    private int score;

    //constructor

    public Hole(int holeNumber, int score) {
        this.holeNumber = holeNumber;
        this.score = score;
    }

    //getter and setter

    protected Hole(Parcel in) {
        holeNumber = in.readInt();
        score = in.readInt();
    }

    public static final Creator<Hole> CREATOR = new Creator<Hole>() {
        @Override
        public Hole createFromParcel(Parcel in) {
            return new Hole(in);
        }

        @Override
        public Hole[] newArray(int size) {
            return new Hole[size];
        }
    };

    public int getHoleNumber() {
        return holeNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(holeNumber);
        dest.writeInt(score);
    }
}
