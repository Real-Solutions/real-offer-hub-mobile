package com.maximo.real_offer_hub_mobile.activities;

import static com.amplifyframework.core.Amplify.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Client;
import com.amplifyframework.datastore.generated.model.User;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityClientSelectionBinding;
import com.maximo.real_offer_hub_mobile.databinding.ActivityNewClientSignUpBinding;

import java.util.Objects;

public class NewClientSignUpActivity extends DrawerBaseActivity {
    public static final String TAG = "NewClientSignUpActivity";
    ActivityNewClientSignUpBinding activityNewClientSignUpBinding;
    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNewClientSignUpBinding = ActivityNewClientSignUpBinding.inflate(getLayoutInflater());
        setContentView(activityNewClientSignUpBinding.getRoot());
        allocateActivityTitle("Client Sign Up");
        setUpAddPropertyButton();
        setUpSaveButton();
        findCurrentUser();
    }

    public void findCurrentUser(){
        StringBuilder email = new StringBuilder();

        Auth.getCurrentUser(
                success->{
                    email.append(success.toString());
                    Log.i(TAG, "this is the email: " + email.toString());
                },
                failure->{
                    Log.w(TAG, "username could not be found", failure);
                }
        );

//        Amplify.API.query(
//                ModelQuery.list(User.class),
//                success -> {
//                    Log.i(TAG, "Added Offers Successfully");
//                    for (User user : success.getData()){
//                        if(Objects.equals(user.getEmail(), email.toString())) currentUser = user;
//                    }
//                },
//
//                failure -> {
//                    Log.w(TAG, "Failed to read Teams from Database");
//                }
//        );
    }

    public void setUpAddPropertyButton(){
        Button button = findViewById(R.id.NewClientAddPropertyButton);
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(view -> {


        });
    }

    public void setUpSaveButton(){
        Button button = findViewById(R.id.SaveClientButton);
        button.setOnClickListener(view -> {
            Button addProperty = findViewById(R.id.NewClientAddPropertyButton);
            addProperty.setVisibility(View.VISIBLE);

        });
    }
}