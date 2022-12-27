package com.maximo.real_offer_hub_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.maximo.real_offer_hub_mobile.activities.DataTest;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "mainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupButtons();
    }

    public void setupButtons(){

        Button goToDataTestButton = this.findViewById(R.id.MainActivityButtonDataTest);
        goToDataTestButton.setOnClickListener(view ->
            startActivity(new Intent(this, DataTest.class))
        );
    }
}