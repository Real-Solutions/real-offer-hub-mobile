package com.maximo.real_offer_hub_mobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;
import com.maximo.real_offer_hub_mobile.MainActivity;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.activities.auth.LoginActivity;
import com.maximo.real_offer_hub_mobile.activities.auth.LogoutActivity;
import com.maximo.real_offer_hub_mobile.activities.auth.SignUpActivity;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {

            case R.id.home:
                startActivity(new Intent(this, DashboardActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.my_listings:
                startActivity(new Intent(this, MyListingsActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.add_property:
                startActivity(new Intent(this, ClientSelection.class));
                overridePendingTransition(0,0);
                break;

            case R.id.offer_form:
                startActivity(new Intent(this, OfferFormActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.clients:
                startActivity(new Intent(this, ClientsActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.user_profile:
                startActivity(new Intent(this, UserProfileActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.settings:
                startActivity(new Intent(this, SettingsActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.support:
                startActivity(new Intent(this, SupportActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.signup:
                startActivity(new Intent(this, SignUpActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.logout:
                startActivity(new Intent(this, LogoutActivity.class));
                overridePendingTransition(0,0);
                break;
        }
        return false;
    }

    protected void allocateActivityTitle(String titleString) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }
    }

}