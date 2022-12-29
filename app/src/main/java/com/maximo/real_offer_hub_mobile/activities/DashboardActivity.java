package com.maximo.real_offer_hub_mobile.activities;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.adapter.Adapter;
import com.maximo.real_offer_hub_mobile.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends DrawerBaseActivity {

    ActivityDashboardBinding activityDashboardBinding;
    RecyclerView recyclerView;
    List<ModelB> modelList;

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

        dataTestButton();
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