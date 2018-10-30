package com.example.milsteam4144.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime
{
    //Declare member fields
    private UUID mId; //Unified Unique Identifier
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    //Constructor that initializes the ID and date fields
    public Crime()
    {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    //Getters and Setters
    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

}
