package com.example.milsteam4144.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class CrimeFragment extends Fragment
{
    //the model
    private Crime mCrime;//Crime object with the variable name mCrime
    private EditText mTitleField;//EditText Widget that sets the mTitle property of Crime instance
    private Button mDateButton;//Button Widget that sets the mDate property of the Crime instance
    private CheckBox mSolvedCheckBox; //Checkbox Widget to set the mSolved property of the Crime instance

    @Override //Gets the data from the model that is needed to create the view
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override //Displays the view
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        //View v is what is returned at the end of the method

        //Code for the mSolvedCheckBox
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
        @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            mCrime.setSolved(isChecked);//Sets the mSolved property of the Crime instance
        }
        });

        //Code for the mDateButton
        mDateButton = (Button) v.findViewById(R.id.crime_date);//R.id always points to a UI element (in the XML)
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        //Code for the mTitleField
        mTitleField = (EditText) v.findViewById(R.id.crime_title); //This references the mTitleField to the EditText Widget for the crime_title resource
        //Listener for the mTitleField
        mTitleField.addTextChangedListener(new TextWatcher()
            {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                    //Blank--no text
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                    mCrime.setTitle(s.toString()); //This calls the setTitle method of the Crime instance, passes it the text and assigns it to the mTitle property of the object
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                    //Blank--no text
            }
        });

        return v;
    }
}
