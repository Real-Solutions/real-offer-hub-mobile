package com.maximo.real_offer_hub_mobile.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.maximo.real_offer_hub_mobile.MainActivity;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.DashboardActivity;
import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivityLoginBinding;

public class LoginActivity extends DrawerBaseActivity {

    public static final String TAG = "LoginActivity";
    public static final String EMAIL_TAG = "email";
    ActivityLoginBinding activityLoginBinding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());
        allocateActivityTitle("Login");
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
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
                        Intent goToDashboardIntent = new Intent(this, DashboardActivity.class);
                        goToDashboardIntent.putExtra(EMAIL_TAG, userEmail);
                        startActivity(goToDashboardIntent);
                    },
                    failure -> {
                        Log.i(TAG, "Login failed: " + failure);
                        runOnUiThread(() -> Toast.makeText(this, "Sign In failed!", Toast.LENGTH_SHORT).show());
                    }
            );
        });
    }

    public void sharedPreferences(String userEmail){
        String email = preferences.getString(EMAIL_TAG, userEmail);
    }
}