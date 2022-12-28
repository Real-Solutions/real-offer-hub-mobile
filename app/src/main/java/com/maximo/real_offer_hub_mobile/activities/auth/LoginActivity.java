package com.maximo.real_offer_hub_mobile.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.maximo.real_offer_hub_mobile.MainActivity;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivityLoginBinding;

public class LoginActivity extends DrawerBaseActivity {

    public static final String TAG = "LoginActivity";
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());
        allocateActivityTitle("Login");
        setUpSignInForm();
    }

    public void setUpSignInForm(){

        findViewById(R.id.LoginActivtyBtnLogin).setOnClickListener(v -> {
            String userEmail = ((EditText) findViewById(R.id.LoginActivityTextEditEmail)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.LoginActivityTextEditPassword)).getText().toString();

            // make a login call to Cognito
            Amplify.Auth.signIn(
                    userEmail,
                    userPassword,
                    success -> {
                        Log.i(TAG, "Login successful: " + success);
                        Intent goToDashboardIntent = new Intent(this, MainActivity.class);
                        startActivity(goToDashboardIntent);
                    },
                    failure -> {
                        Log.i(TAG, "Login failed: " + failure);
                        runOnUiThread(() -> Toast.makeText(this, "Sign In failed!", Toast.LENGTH_SHORT).show());
                    }
            );
        });
    }
}