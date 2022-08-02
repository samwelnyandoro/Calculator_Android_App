package com.calculator.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Stopwatch extends AppCompatActivity
{
    Button b21,b22;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);

        b21 = (Button) findViewById(R.id.button1);
        b22 = (Button) findViewById(R.id.button2);

        b21.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity3();
            }
        });

        b22.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity4();
            }
        });


    }
    public void openActivity3()
    {
        Intent intent = new Intent(this, Chronometer.class);
        startActivity(intent);
    }

    public void openActivity4()
    {
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
    }
}