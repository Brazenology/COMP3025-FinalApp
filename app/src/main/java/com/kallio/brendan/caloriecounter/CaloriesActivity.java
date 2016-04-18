package com.kallio.brendan.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Owner on 2016-04-17.
 */
public class CaloriesActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_update);
    }

    public void onBackButtonClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void onOkButtonClick(View v) {
        //Gets the initial value of calories remaining
        Intent intent = getIntent();
        int userValue = intent.getIntExtra("parsedNumber", 0);

        EditText displayCalories = (EditText) findViewById(R.id.userInput);

        //int that holds the updated calorie intake for the day
        int caloriesUpdate = 0;


        if (caloriesUpdate >= 0 || caloriesUpdate <= 0 ) {
            caloriesUpdate = userValue - Integer.parseInt(displayCalories.getText().toString());
        }
        else {
            caloriesUpdate = userValue;
        }

        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.putExtra("caloriesUpdate", caloriesUpdate);
        startActivity(intent2);

    }
}
