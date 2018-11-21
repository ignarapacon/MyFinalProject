package com.rapacon.igna.myfinalproject;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
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

    public void Tip(View v) {
        Toast toast1 = Toast.makeText(this, "Tip 1: Your Kit should be in a portable, easy to lift and carry, container located near an exit of your house ", Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast1.show();

        Toast toast2 = Toast.makeText(this, "Tip 2: Each family member should have their own 72 hour kit with food clothing and water. Distribute heavy items between kits.", Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast2.show();

        Toast toast3 = Toast.makeText(this, "Tip 3: Keep a light source in the top of your kit so you can find it quickly in the dark", Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast3.show();

        Toast toast4 = Toast.makeText(this, "Tip 4: Inspect your 72 hour kit at least twice a year. Check Medication, check children’s clothing for proper fit, and check expiration dates on batteries, light sticks, warm packs, food and water.", Toast.LENGTH_LONG);
        toast4.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast4.show();

    }
}