package com.example.milsteam4144.criminalintent;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerNonConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        //Get the fragment manager
        // android.support means it is a support version of fragment manager(uses a library that you include in app)
        //and not the native(built into device)
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//Ask the Fragment Manager for the fragment by it's container view ID and assign it to the fragment variable

        if (fragment == null)
        //If CrimeActivity was recreated after being destroyed, Fragment Manager will have saved the list of fragments, so will not be null
            //When Crime Activity id recreated, Fragment Manager retrieves the list and re-creates the listed fragments
            //If none of this has already happened, fragment will be null and then a new one created below
        {
            fragment = new CrimeFragment();

            //Creates and commits a fragment transaction
            //Fragment transactions add, remove, attach, detach or replace fragments in the fragment list NOTES PG 149
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }
    }
}
