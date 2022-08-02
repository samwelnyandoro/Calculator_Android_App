package com.calculator.calculator;

import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Chronometer extends AppCompatActivity
{
    android.widget.Chronometer chronometer;
    private boolean start;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronometer);

        chronometer = findViewById(R.id.time);
        chronometer.setOnChronometerTickListener(new android.widget.Chronometer.OnChronometerTickListener()
        {
            @Override
            public void onChronometerTick(android.widget.Chronometer chronometerChanged)
            {
                chronometer = chronometerChanged;
            }
        });
    }

    public void startStopChronometer(View view)
    {
        if(start)
        {
            chronometer.stop();
            start=false;
            ((Button)view).setText("Start");
        }
        else
        {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            start = true;
            ((Button)view).setText("Stop");
        }
    }
}
