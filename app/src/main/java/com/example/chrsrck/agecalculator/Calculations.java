package com.example.chrsrck.agecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Calculations extends Activity {

    public final static String TAG = Calculations.class.getSimpleName();

    protected int mAgeDogYears;
    protected int mAgeWeeks;
    protected int mAgeDays;
    protected int mAgeMinutes;
    protected int mAgeHours;

    private TextView mDogTextView;
    private TextView mWeeksTextView;
    private TextView mDaysTextView;
    private TextView mMinutesTextView;
    private TextView mHoursTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);

        mDogTextView = (TextView) findViewById(R.id.dogTextView);
        mWeeksTextView = (TextView) findViewById(R.id.weeksTextView);
        mDaysTextView = (TextView) findViewById(R.id.daysTextView);
        mMinutesTextView = (TextView) findViewById(R.id.minutesTextView);
        mHoursTextView = (TextView) findViewById(R.id.hoursTextView);

        Intent calcIntent = getIntent();
        int age = calcIntent.getIntExtra("AGE", 0);
        convertAge(age);

        mDogTextView.setText(getString(R.string.dogStr) + " " + Integer.toString(mAgeDogYears));
        mWeeksTextView.setText(getString(R.string.weekStr) + " " + Integer.toString(mAgeWeeks));
        mDaysTextView.setText(getString(R.string.dayStr) + " " + Integer.toString(mAgeDays));
        mMinutesTextView.setText(getString(R.string.minuteStr) + " " + Integer.toString(mAgeMinutes));
        mHoursTextView.setText(getString(R.string.hourStr) + " " + Integer.toString(mAgeHours));
    }

    private void convertAge(int age){
        mAgeDogYears = age / 7;
        mAgeWeeks = age * 52;
        mAgeDays = age * 365;
        mAgeMinutes = mAgeDays * 3600;
        mAgeHours = mAgeDays * 24;
    }
}
