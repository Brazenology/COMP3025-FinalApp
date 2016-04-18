package com.kallio.brendan.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
}
