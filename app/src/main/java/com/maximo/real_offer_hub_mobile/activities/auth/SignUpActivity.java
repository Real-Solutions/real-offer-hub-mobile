package com.maximo.real_offer_hub_mobile.activities.auth;

import static com.amplifyframework.core.Amplify.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.User;
import com.amplifyframework.datastore.generated.model.UserType;
import com.maximo.real_offer_hub_mobile.MainActivity;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivitySignUpBinding;

public class SignUpActivity extends DrawerBaseActivity {
    public static final String TAG = "signUpActivity";
    public static final String SIGNUP_EMAIL_TAG = "Signup_Email_Tag";
    UserType userType;
    ActivitySignUpBinding activitySignUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(activitySignUpBinding.getRoot());
        allocateActivityTitle("Signup");
        setUpSignUpForm();
        setUpUserType();
    }

    public void setUpSignUpForm(){
        findViewById(R.id.SignUpActivityBtnSignUp).setOnClickListener(v -> {
            String userEmail = ((EditText) findViewById(R.id.SignUpActivityTextEditEmail)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.SignUpActivityeditTextTextPassword)).getText().toString();
            Amplify.Auth.signUp(
                    userEmail,
                    userPassword,
                    AuthSignUpOptions.builder()
                            .userAttribute(AuthUserAttributeKey.email(), userEmail)
                            .build(),
                    success -> {
                        Log.i(TAG, "SignUp successful for Cognito user! " + success);
                        Intent goToVerifyActivity = new Intent(this, ConfirmationActivity.class);
                        goToVerifyActivity.putExtra(SIGNUP_EMAIL_TAG, userEmail);


                        startActivity(goToVerifyActivity);
                    },
                    failure -> {
                        Log.w(TAG, "Sign up failed with username: " + userEmail + "with message " + failure);
                        runOnUiThread(() -> Toast.makeText(this, "SignUp Failed", Toast.LENGTH_SHORT).show());
                    }
            );
        });
    }


    public void setUpUserType(){
        Amplify.API.query(
                ModelQuery.list(UserType.class),
                success -> {
                    for (UserType type : success.getData()){
                        userType = type;
                    }
                    Log.i(TAG, "Read User Type Successful");
                },
                failure -> {
                    Log.w(TAG, "Did not read UserType successfully from database");
                }
        );
    }
}