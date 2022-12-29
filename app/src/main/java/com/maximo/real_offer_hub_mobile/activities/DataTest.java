package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Client;
import com.amplifyframework.datastore.generated.model.User;
import com.amplifyframework.datastore.generated.model.UserType;
import com.maximo.real_offer_hub_mobile.R;

public class DataTest extends AppCompatActivity {
    public static final String TAG = "dataTest";
    private static UserType userType;
    private static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);
        setupClient();
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
                    Log.i(TAG, "Read User Type Successful");
                },
                failure -> {
                    Log.w(TAG, "Did not read UserType successfully from database");
                }
        );

        setupUserTypeButton();

        Amplify.API.query(
                ModelQuery.list(User.class),
                success -> {
                    for (User users: success.getData()){
                        user = users;
                    }
                    Log.i(TAG, "Read User Type Successful");
                },
                failure -> {
                    Log.w(TAG, "Did not read UserType successfully from database");
                }
        );

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
        .email(((EditText)findViewById(R.id.DataTestEditTextEmail)).getText().toString())
        .userType(userType)
        .build();

    Amplify.API.mutate(
            ModelMutation.create(user),
            success -> Log.i(TAG, "Success for User"),
            failure -> Log.e(TAG, "Failure for user", failure)
    );
    }

    private void setupClient(){
        Button addClientButton = findViewById(R.id.DataTestButtonAddClient);
        addClientButton.setOnClickListener(view -> {
            saveClient();
        });
    }

    private void saveClient(){

        Client client = Client.builder()
                .email(((EditText)findViewById(R.id.DataTesteditTextTextEmailClient)).getText().toString())
                .user(user)
                .build();

        Amplify.API.mutate(
                ModelMutation.create(client),
                success -> Log.i(TAG, "Success for Client"),
                failure -> Log.e(TAG, "Failure for Client")
        );
    }
}