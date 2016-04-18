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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView consecDaysCounter = (TextView) findViewById(R.id.consecDays);
        TextView largeMealCounter = (TextView) findViewById(R.id.largeMealCounter);
        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);

        Intent intent2 = getIntent();
        int caloriesUpdate = intent2.getIntExtra("caloriesUpdate", 0);
        calories.setText("" + caloriesUpdate);
        int largeMeal = intent2.getIntExtra("isLargeMeal", 0);

        largeMealCounter.setText("" + largeMeal);

        consecDaysCounter.setText("" + intent2.getIntExtra("consecDaysPassed", 0));


        //int currentCalories = Integer.parseInt(calories.getText().toString());

    }



    public void onCompleteDayButtonClick (View v) {
        TextView currentGrade = (TextView) findViewById(R.id.gradeTextView);
        TextView largeMealsEaten = (TextView) findViewById(R.id.largeMealCounter);
        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);
        TextView consecDays = (TextView) findViewById(R.id.consecDays);
        int currentConsecDays = Integer.parseInt(consecDays.getText().toString());
        int currentGradeParsed = Integer.parseInt(currentGrade.getText().toString());

        //Determine updated Grade
        Random r = new Random();
        int randomScore = r.nextInt(10 - 5) + 5;

        Random rNeg = new Random();
        int randomPenalty = rNeg.nextInt(15 - 7) + 7;

        //Checks to see if consecutive days should be incremented up or reset
        if (Integer.parseInt(calories.getText().toString()) >= -250 && Integer.parseInt(calories.getText().toString())  <= 250) {
            currentConsecDays++;
            currentGradeParsed += randomScore;
            consecDays.setText("" + currentConsecDays);
        }
        else {
            consecDays.setText("" + 0);
        }

        if(Integer.parseInt(largeMealsEaten.getText().toString()) >=2 && Integer.parseInt(largeMealsEaten.getText().toString()) <= 4) {
            currentGradeParsed += randomScore;
        }

        else {
            currentGradeParsed -= randomPenalty;
        }

        if (currentGradeParsed < 300) {
            currentGrade.setText("" + currentGradeParsed);
        }
        else {
            currentGrade.setText("" + 300);
        }








        //resets calories remaining and large meals eaten
        calories.setText("" + 0);
        largeMealsEaten.setText("" + 0);
    }

    public void onUpdateButtonClick(View v){

        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);
        TextView largeMeals = (TextView) findViewById(R.id.largeMealCounter);
        TextView consecDays = (TextView) findViewById(R.id.consecDays);

        String caloriesRemaining = calories.getText().toString();
        int caloriesParsed = Integer.parseInt(caloriesRemaining);
        int largeMealsParsed = Integer.parseInt(largeMeals.getText().toString());
        int consecDaysParsed = Integer.parseInt(consecDays.getText().toString());

        Intent intent = new Intent(this, CaloriesActivity.class);
        intent.putExtra("parsedNumber", caloriesParsed);
        intent.putExtra("parsedLargeMeals", largeMealsParsed);
        intent.putExtra("parsedConsecDays", consecDaysParsed);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
}