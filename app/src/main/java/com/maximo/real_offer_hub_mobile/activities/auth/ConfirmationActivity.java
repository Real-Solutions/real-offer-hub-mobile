package com.maximo.real_offer_hub_mobile.activities.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.maximo.real_offer_hub_mobile.R;

public class ConfirmationActivity extends AppCompatActivity {
    public static final String TAG = "ConfirmationActivity";
    Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        callingIntent = getIntent();

        setUpVerifyForm();
    }

    public void setUpVerifyForm(){
        String userEmail = callingIntent.getStringExtra(SignUpActivity.SIGNUP_EMAIL_TAG);
        findViewById(R.id.ConfirmationActivityBtnConfirm).setOnClickListener(v -> {
            String verificationCode = ((EditText) findViewById(R.id.ConfirmationActivityTextEditConfirmationCode)).getText().toString();
            Amplify.Auth.confirmSignUp(
                    userEmail,
                    verificationCode,
                    success -> {
                        Log.i(TAG, "Verification succeeded: " + success.toString());
                        Intent goToSignInActivity = new Intent(this, LoginActivity.class);
                        goToSignInActivity.putExtra(SignUpActivity.SIGNUP_EMAIL_TAG, userEmail);
                        startActivity(goToSignInActivity);
                    },
                    failure -> {
                        Log.i(TAG, "Verification failed with username: " + userEmail + " with this message: " + failure);
                        runOnUiThread(() -> Toast.makeText(ConfirmationActivity.this, "Verify account failed!", Toast.LENGTH_SHORT));
                    }
            );
        });
    }
}