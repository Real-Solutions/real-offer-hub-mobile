package com.maximo.real_offer_hub_mobile.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivityLoginBinding;

public class LoginActivity extends DrawerBaseActivity {

    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());
        allocateActivityTitle("Login");
    }
}