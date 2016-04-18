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

        //TextView caloriesRemaining = (TextView) findViewById(R.id.caloriesRemaining);
        //caloriesRemaining.setText(getIntent().getExtras().getString("CALORIESEATEN"));

        updateFields();
    }

    private void updateFields() {

        Intent intent2 = getIntent();
        int caloriesUpdate = intent2.getIntExtra("caloriesUpdate", 0);

        EditText calories = (EditText)findViewById(R.id.caloriesRemainingEditText);
        int currentCalories = Integer.parseInt(calories.getText().toString());

        if (caloriesUpdate < currentCalories) {
            if(caloriesUpdate > 0) {
                calories.setText("" + caloriesUpdate);
            }
        }
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