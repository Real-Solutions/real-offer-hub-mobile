package com.maximo.real_offer_hub_mobile;

import static com.amplifyframework.core.Amplify.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
import com.amplifyframework.core.Amplify;
import com.maximo.real_offer_hub_mobile.activities.DataTest;


import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {
    public static final String TAG = "mainActivity";
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        allocateActivityTitle("Main Activity");

    }

    @Override
    protected void onResume() {
        super.onResume();
//        setupButtons();
    }




//        Amplify.Auth.getCurrentUser(
//                success->{
//                    String username = success.getUsername();
//                    Log.i(TAG, "Username is: " + username);
//                    R.id.login.setVisibility(View.GONE);
//                    signUp.setVisibility(View.GONE);
//                },
//                failure->{
//                    R.id.logout.setVisibility(View.GONE);
//                }
//        );
    }

//    public void setupButtons(){
//
//        Button goToDataTestButton = this.findViewById(R.id.MainActivityButtonDataTest);
//        goToDataTestButton.setOnClickListener(view ->
//            startActivity(new Intent(this, DataTest.class))
//        );
//    }
//}