package com.example.milsteam4144.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//This is a singleton class--only one instance of the class is created & it is global
public class CrimeLab {
    private static CrimeLab sCrimeLab; // Declare the field for the singleton object-"s" means static
    private List<Crime> mCrimes; //Create an empty list to hold the Crime objects

    //Private Constructor
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        //Use a for loop to populate the list with 100 crimes
        for (int i = 0; i < 100; i++){
            Crime crime = new Crime ();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); //Every other one
            mCrimes.add(crime);
        }
    }

    //Getter for the list mCrimes, returns the entire list
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    //Returns the specific crime if the given id matches that of a crime in the list
    public Crime getCrimeByID(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

    //Method to return the singleton object (sCrimeLab) that holds the list mCrimes
    public static CrimeLab get(Context context) //This will return the (1) CrimeLab object
    {
        if (sCrimeLab == null) //If the object doesn't exist, create it
        {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
}
