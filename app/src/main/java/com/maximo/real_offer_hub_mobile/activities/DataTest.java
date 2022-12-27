package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.User;
import com.amplifyframework.datastore.generated.model.UserType;
import com.maximo.real_offer_hub_mobile.R;

public class DataTest extends AppCompatActivity {
    public static final String TAG = "dataTest";
    private static UserType userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);
    }

    @Override
    protected void onResume(){
        super.onResume();

        Amplify.API.query(
                ModelQuery.list(UserType.class),
                success -> {
                    for (UserType type : success.getData()){
                        userType = type;
                    }
                    Log.i(TAG, "Read Team Successful");
                },
                failure -> {
                    Log.w(TAG, "Did not read teams successfully from database");
                }
        );

        setupUserTypeButton();
        setupUserButton();
    }

    private void setupUserTypeButton(){
        Button addUserTypeButton = findViewById(R.id.DataTestButtonUserTypeButton);
        addUserTypeButton.setOnClickListener(view ->
        saveUserType()
                );
    }

    private void saveUserType(){
        UserType userType =  UserType.builder()
        .type(((EditText)findViewById(R.id.DataTestEditTextUserType)).getText().toString())
                .build();

        Amplify.API.mutate(
                ModelMutation.create(userType),
                success -> Log.i(TAG, "Success for User Type"),
                failure -> Log.e(TAG, "Failure for User Type", failure)
        );
    }

    private void setupUserButton(){
        Button addUserButton = findViewById(R.id.DataTestButtonAddUser);
        addUserButton.setOnClickListener(view ->
        saveUser()
            );
    }

    private void saveUser(){

        User user = User.builder()
        .firstName(((EditText)findViewById(R.id.DataTestEditTextFirstName)).getText().toString())
        .lastName(((EditText)findViewById(R.id.DataTestEditTextLastName)).getText().toString())
        .userType(userType)
        .build();

    Amplify.API.mutate(
            ModelMutation.create(user),
            success -> Log.i(TAG, "Success for User"),
            failure -> Log.e(TAG, "Failure for user", failure)
    );
    }
}