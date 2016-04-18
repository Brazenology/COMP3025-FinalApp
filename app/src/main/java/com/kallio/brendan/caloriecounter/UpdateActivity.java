package com.kallio.brendan.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Owner on 2016-04-17.
 */
public class UpdateActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_main);
    }

    public void onBackButtonClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void onOkButtonClick(View v) {
        int estimatedIntake = 0;
        RadioButton male = (RadioButton) findViewById(R.id.maleRadioButton);
        RadioButton female = (RadioButton) findViewById(R.id.femaleRadioButton);
        EditText weight = (EditText) findViewById(R.id.weightEditText);
        int weightInput = Integer.parseInt(weight.getText().toString());


        if (male.isChecked()) {
            if (weightInput < 110){
                estimatedIntake = 1200;
            }
            else if (weightInput >= 110 && weightInput <= 150) {
                estimatedIntake = 1500;
            }
            else if (weightInput > 150 && weightInput <= 180) {
                estimatedIntake = 2000;
            }
            else if (weightInput > 180 && weightInput <= 210) {
                estimatedIntake = 2200;
            }
            else if (weightInput > 210 && weightInput <= 250) {
                estimatedIntake = 2500;
            }
            else {
                estimatedIntake = 2600;
            }
        }

        if (female.isChecked()) {
            if (weightInput < 110){
                estimatedIntake = 1000;
            }
            else if (weightInput >= 110 && weightInput <= 150) {
                estimatedIntake = 1300;
            }
            else if (weightInput > 150 && weightInput <= 180) {
                estimatedIntake = 1750;
            }
            else if (weightInput > 180 && weightInput <= 210) {
                estimatedIntake = 2000;
            }
            else if (weightInput > 210 && weightInput <= 250) {
                estimatedIntake = 2100;
            }
            else {
                estimatedIntake = 2200;
            }
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("setupComplete", estimatedIntake);
        startActivity(intent);
    }
}
