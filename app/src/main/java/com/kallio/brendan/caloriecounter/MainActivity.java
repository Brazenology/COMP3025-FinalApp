package com.kallio.brendan.caloriecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);
        Intent intent2 = getIntent();
        int caloriesUpdate = intent2.getIntExtra("caloriesUpdate", 0);
        calories.setText("" + caloriesUpdate);

        //int currentCalories = Integer.parseInt(calories.getText().toString());

    }



    public void onCompleteDayButtonClick (View v) {
        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);
        TextView consecDays = (TextView) findViewById(R.id.consecDays);
        int currentConsecDays = Integer.parseInt(consecDays.getText().toString());

        if (Integer.parseInt(calories.getText().toString()) >= -250 && Integer.parseInt(calories.getText().toString())  <= 250) {
            currentConsecDays++;
            consecDays.setText("" + currentConsecDays);
        }
        else {
            consecDays.setText("" + 0);
        }

        calories.setText("" + 0);
    }

    public void onSetupButtonClick(View v){
        Intent i = new Intent(this, UpdateActivity.class);
        startActivity(i);
    }

    public void onUpdateButtonClick(View v){

        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);


        String caloriesRemaining = calories.getText().toString();
        int caloriesParsed = Integer.parseInt(caloriesRemaining);

        Intent intent = new Intent(this, CaloriesActivity.class);
        intent.putExtra("parsedNumber", caloriesParsed);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
}