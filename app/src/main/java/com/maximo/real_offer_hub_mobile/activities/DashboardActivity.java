package com.maximo.real_offer_hub_mobile.activities;


import androidx.recyclerview.widget.LinearLayoutManager;

import static com.amplifyframework.core.Amplify.Auth;
import static com.maximo.real_offer_hub_mobile.activities.auth.LoginActivity.EMAIL_TAG;

import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.model.Preference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Offer;

import android.preference.PreferenceManager;


import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.datastore.generated.model.Client;
import com.amplifyframework.datastore.generated.model.Property;
import com.amplifyframework.datastore.generated.model.User;

import com.amplifyframework.datastore.generated.model.UserType;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.auth.LoginActivity;
import com.maximo.real_offer_hub_mobile.activities.auth.SignUpActivity;
import com.maximo.real_offer_hub_mobile.adapter.Adapter;
import com.maximo.real_offer_hub_mobile.adapter.RecyclerViewAdapter;
import com.maximo.real_offer_hub_mobile.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

public class DashboardActivity extends DrawerBaseActivity {
    public static final String TAG = "DashboardActivity";
    ActivityDashboardBinding activityDashboardBinding;
    RecyclerView recyclerView;
    List<ModelB> modelList;

    List<Offer> offerList;
    RecyclerViewAdapter recyclerViewAdapter;

    StringBuilder cognitoID = new StringBuilder();
    Intent callingIntent;
    private static UserType userType;
    boolean[] state = new boolean[1];
    StringBuilder word = new StringBuilder();
    CompletableFuture<List<User>> usersfuture = new CompletableFuture<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");

        compareToExistingUsers();


        callingIntent = getIntent();
        getUserType();
        getData();
        recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(modelList);
        recyclerView.setAdapter(adapter);

//        getDataFromDB();
//        setupRecyclerView();
        dataTestButton();
        addPropertyButton();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                getAuthUser();
            }
        }, 20000);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }


    public void getAuthUser(){
        String newUserEmail = callingIntent.getStringExtra(LoginActivity.EMAIL_TAG);
        usersfuture.complete(users);
        Auth.getCurrentUser(
                success->{
                    cognitoID.append(success.getUserId());
                    boolean state = true;
                    for(User user : users){
                        if(user.getCognitoId().equals(cognitoID.toString())){
                            state = false;
                        }
                    }
                    if(state){
                        createDynamoUser(newUserEmail, success.getUserId());
                    Log.i(TAG, "this is the userID: " + cognitoID.toString() + " with email: " + newUserEmail);
                    }
                    else{
                    Log.i(TAG, "Not created");
                    }
                },
                failure->{
                    Log.w(TAG, "username could not be found", failure);
                }
        );

//        if(compareToExistingUsers(cognitoID.toString())){
//            createDynamoUser(newUserEmail, cognitoID.toString());
//        }

    }

    public void compareToExistingUsers(){
        Amplify.API.query(
                ModelQuery.list(User.class),
                success -> {
                    for(User user : success.getData()){
                        users.add(user);
                    }
                    Log.i(TAG, "Successfully accessed users" + " this is the state: " + state[0]);
                },
                failure -> {
                    Log.w(TAG, "Failed to read users");
                }
        );
    }

    public void createDynamoUser(String email, String cognitoId){

    User user = User.builder()
        .email(email)
        .cognitoId(cognitoId)
        .userType(userType)
        .build();

    Amplify.API.mutate(
            ModelMutation.create(user),
            success -> Log.i(TAG, "Success for User"),
            failure -> Log.e(TAG, "Failure for user", failure)
    );


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

    public void addPropertyButton(){
        FloatingActionButton addProperty = DashboardActivity.this.findViewById(R.id.DashboardFloatingActionBtnAddProperty);
        addProperty.setOnClickListener(view -> {
            Intent goToAddPropertyIntent = new Intent(DashboardActivity.this, AddPropertyActivity.class);
            startActivity(goToAddPropertyIntent);
        });
    }



//    private void getDataFromDB(){
//        offerList.clear();
//        Amplify.API.query(
//                ModelQuery.list(Offer.class),
//                success -> {
//                    Log.i(TAG, "Read task list successfully");
//                    for (Offer databaseOfferList : success.getData()) {
//                        offerList.add(databaseOfferList);
//                    }
//                    runOnUiThread(() -> recyclerViewAdapter.notifyDataSetChanged());
//                },
//                failure -> Log.i(TAG, "Failed to read offer list")
//        );
//    }
//
//    public void setupRecyclerView(){
//        offerList = new ArrayList<>();
//        recyclerView = findViewById(R.id.recyclerView);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(offerList);
//        recyclerView.setAdapter(recyclerViewAdapter);
//    }

    public void getUserType(){
        Amplify.API.query(
                ModelQuery.list(UserType.class),
                success -> {
                    for (UserType type : success.getData()){
                        userType = type;
                    }
                    if(userType == null){
                        saveUserType();
                        getUserType();
                    }
                    Log.i(TAG, "Read User Type Successful");
                },
                failure -> {
                    Log.w(TAG, "Did not read UserType successfully from database");
                }
        );
    }

    private void saveUserType(){
        UserType userType =  UserType.builder()
        .type("agent")
                .build();

        Amplify.API.mutate(
                ModelMutation.create(userType),
                success -> Log.i(TAG, "Success for User Type"),
                failure -> Log.e(TAG, "Failure for User Type", failure)
        );
    }

}