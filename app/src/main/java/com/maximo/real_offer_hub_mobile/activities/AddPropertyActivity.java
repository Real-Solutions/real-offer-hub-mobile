package com.maximo.real_offer_hub_mobile.activities;

import static com.amplifyframework.core.Amplify.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Client;
import com.amplifyframework.datastore.generated.model.Property;
import com.amplifyframework.datastore.generated.model.User;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityAddPropertyBinding;

import java.util.ArrayList;
import java.util.Date;

public class AddPropertyActivity extends DrawerBaseActivity {
    public final static String TAG = "AddPropertyActivity";
    User user;
    ActivityAddPropertyBinding activityAddPropertyBinding;
    String cognitoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddPropertyBinding = ActivityAddPropertyBinding.inflate(getLayoutInflater());
        setContentView(activityAddPropertyBinding.getRoot());
        allocateActivityTitle("Add Property");
        getCognitoID();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupAddPropertyButton();
        setCurrentUser();
    }

    private void getCognitoID(){
        Auth.getCurrentUser(
                success->{
                    cognitoID = success.getUserId();
                },
                failure->{
                    Log.w(TAG, "username could not be found", failure);
                }
        );
    }

    private void setCurrentUser(){
        Amplify.API.query(
                ModelQuery.list(User.class),
                success -> {
                    Log.i(TAG, "Added Offers Successfully");
                    for (User ur : success.getData()) {
                        if(cognitoID.equals(ur.getCognitoId())) user = ur;
                    }
                },

                failure -> {
                    Log.w(TAG, "Failed to read Teams from Database");
                }
        );
    }

    private void setupAddPropertyButton(){
        Button addPropertyButton = findViewById(R.id.AddPropertyBtnAddProperty);
        addPropertyButton.setOnClickListener(view ->{
                setupSavePropertyButton();
                startActivity(new Intent(this, DashboardActivity.class));
        }
        );
    }

    public void setupSavePropertyButton(){

        Property property = Property.builder()
                .address(((EditText)findViewById(R.id.AddPropertyTextEditPropertyAddress)).getText().toString())
                .price(Double.parseDouble(((EditText)findViewById(R.id.AddPropertyTextEditListPrice)).getText().toString()))
                .initialPosting(new Temporal.Date(new Date(), 0))
                .numberOfRooms(Integer.parseInt(((EditText)findViewById(R.id.AddPropertyTextEditRooms)).getText().toString()))
                .numberOfBathrooms(Integer.parseInt(((EditText)findViewById(R.id.AddPropertyTextEditBathrooms)).getText().toString()))
                .squareFootage(Double.parseDouble(((EditText)findViewById(R.id.AddPropertyTextEditSquareFootage)).getText().toString()))
                .yearBuilt(Integer.parseInt(((EditText)findViewById(R.id.AddPropertyTextEditYearBuilt)).getText().toString()))
                .priceString("$600000")
                .squareFootageString("1100")
                .user(user)
                .build();

        Amplify.API.mutate(
                ModelMutation.create(property),
                success -> Log.i(TAG, "AddPropertyActivity.onCreate(): Property saved successfully!"),
                failure -> Log.w(TAG, "AddPropertyActivity.onCreate(): failed to save a task", failure)
        );
        Toast.makeText(this, "Property Saved!", Toast.LENGTH_SHORT).show();
    }
}