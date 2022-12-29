package com.maximo.real_offer_hub_mobile.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Offer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.adapter.Adapter;
import com.maximo.real_offer_hub_mobile.adapter.RecyclerViewAdapter;
import com.maximo.real_offer_hub_mobile.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends DrawerBaseActivity {

    ActivityDashboardBinding activityDashboardBinding;
    RecyclerView recyclerView;
    List<ModelB> modelList;
    List<Offer> offerList;
    RecyclerViewAdapter recyclerViewAdapter;

    public final static String TAG = "DashboardActivityTag";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");


        getData();
        recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(modelList);
        recyclerView.setAdapter(adapter);

//        getDataFromDB();
//        setupRecyclerView();
        dataTestButton();
        addPropertyButton();
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

}