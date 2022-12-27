package com.maximo.real_offer_hub_mobile.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivitySignUpBinding;

public class SignUpActivity extends DrawerBaseActivity {

    ActivitySignUpBinding activitySignUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(activitySignUpBinding.getRoot());
        allocateActivityTitle("Signup");
    }
}