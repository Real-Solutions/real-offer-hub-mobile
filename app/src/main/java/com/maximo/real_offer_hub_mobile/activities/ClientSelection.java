package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityClientSelectionBinding;

public class ClientSelection extends DrawerBaseActivity {

    public final static String TAG = "ClientSelectionActivity";
    Spinner clientSpinner;
    ActivityClientSelectionBinding activityClientSelectionBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityClientSelectionBinding = ActivityClientSelectionBinding.inflate(getLayoutInflater());
        setContentView(activityClientSelectionBinding.getRoot());
        allocateActivityTitle("Client Selection");

        clientSpinner = findViewById(R.id.ClientSpinner);
        setUpSignUpButton();
    }

    public void setUpSignUpButton(){
        Button button = findViewById(R.id.SignUpNewClientButton);
        button.setOnClickListener(view -> startActivity(new Intent(this, NewClientSignUpActivity.class)));
    }
}