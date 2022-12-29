package com.maximo.real_offer_hub_mobile.activities;

import static com.amplifyframework.core.Amplify.Auth;
import static com.maximo.real_offer_hub_mobile.activities.auth.LoginActivity.EMAIL_TAG;

import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.model.Preference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Client;
import com.amplifyframework.datastore.generated.model.Property;
import com.amplifyframework.datastore.generated.model.User;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.auth.LoginActivity;
import com.maximo.real_offer_hub_mobile.activities.auth.SignUpActivity;
import com.maximo.real_offer_hub_mobile.adapter.Adapter;
import com.maximo.real_offer_hub_mobile.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends DrawerBaseActivity {
    public static final String TAG = "DashboardActivity";
    ActivityDashboardBinding activityDashboardBinding;
    RecyclerView recyclerView;
    List<ModelB> modelList;
    StringBuilder cognitoID = new StringBuilder();
    Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");

       callingIntent = getIntent();

        getData();
        recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(modelList);
        recyclerView.setAdapter(adapter);

        dataTestButton();
        getAuthUser();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }



    public void getAuthUser(){
        String newUserEmail = callingIntent.getStringExtra(LoginActivity.EMAIL_TAG);
        Auth.getCurrentUser(
                success->{
                    cognitoID.append(success.getUserId());

                    Log.i(TAG, "this is the userID: " + cognitoID.toString() + " with email: " + newUserEmail);
                },
                failure->{
                    Log.w(TAG, "username could not be found", failure);
                }
        );

        if(compareToExistingUsers(cognitoID.toString())){
            createDynamoUser(newUserEmail, cognitoID.toString());
        }

    }

    public boolean compareToExistingUsers(String id){
        Amplify.API.query(
                ModelQuery.list(User.class),
                success -> {
                    Log.i(TAG, "Successfully accessed users");
                    for(User user : success.getData()){
                       // if(id == user.getCognitoId()) return false;

                    }

                },
                failure -> {
                    Log.w(TAG, "Failed to read users");
                }
        );
        return true;
    }

    public void createDynamoUser(String email, String cognitoId){

    }

    public void dataTestButton(){
        Button test = DashboardActivity.this.findViewById(R.id.buttonTest);
        test.setOnClickListener(view -> {
            Intent goToTest = new Intent(this, DataTest.class);
            startActivity(goToTest);
        });
    }

    private void getData() {
        modelList = new ArrayList<>();
        modelList.add(new ModelB("1675 E Main St", "$5,000", "FHA", "Matt Torres", "12/30/22", "7:00pm", "12/31/22"));
        modelList.add(new ModelB("1676 E Main St", "$5,000", "FHA", "Matt Torres", "12/30/22", "7:00pm", "12/31/22"));
        modelList.add(new ModelB("1677 E Main St", "$5,000", "FHA", "Matt Torres", "12/30/22", "7:00pm", "12/31/22"));
    }

}