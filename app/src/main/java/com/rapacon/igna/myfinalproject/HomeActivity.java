package com.rapacon.igna.myfinalproject;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new WhatIsFirstAid()).commit();
            navigationView.setCheckedItem(R.id.nav_FirstAid);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_FirstAid:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WhatIsFirstAid()).commit();
                break;

            case R.id.nav_Injuries:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DisasterRelatedInjuries()).commit();
                break;

            case R.id.nav_LiftsCarries:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LiftsAndCarries()).commit();
                break;

            case R.id.nav_Bandage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BandageStyles()).commit();
                break;

            case R.id.nav_CPR:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PerformCPR()).commit();
                break;

            case R.id.nav_HourKit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SeventyTwoHourKit()).commit();
                break;

            case R.id.nav_LocalNo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EmergencyLocalNumbers()).commit();
                break;

            case R.id.nav_About:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutTheApp()).commit();
                break;

            case R.id.nav_Message:
                Toast.makeText(this, "Welcome to PLUS!", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}