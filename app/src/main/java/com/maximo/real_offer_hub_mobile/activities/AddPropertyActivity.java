package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Property;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityAddPropertyBinding;

import java.util.Date;

public class AddPropertyActivity extends DrawerBaseActivity {
    public final static String TAG = "AddPropertyActivity";

    ActivityAddPropertyBinding activityAddPropertyBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddPropertyBinding = ActivityAddPropertyBinding.inflate(getLayoutInflater());
        setContentView(activityAddPropertyBinding.getRoot());
        allocateActivityTitle("Add Property");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupAddPropertyButton();
    }

    private void setupAddPropertyButton(){
        Button addPropertyButton = findViewById(R.id.AddPropertyBtnAddProperty);
        addPropertyButton.setOnClickListener(view ->
                setupSavePropertyButton()
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
                .build();

        Amplify.API.mutate(
                ModelMutation.create(property),
                success -> Log.i(TAG, "AddPropertyActivity.onCreate(): made a task successfully!"),
                failure -> Log.w(TAG, "AddPropertyActivity.onCreate(): failed to make a task", failure)
        );
        Toast.makeText(this, "Property Saved!", Toast.LENGTH_SHORT).show();
    }
}