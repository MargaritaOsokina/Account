package com.example.margarita.project6;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // if (id == R.id.action_settings) {
        //     return true;
        // }

        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.nav_income:
                Intent intent = new Intent(this, ActivityIncome.class);
                startActivity(intent);
                return true;

            case R.id.nav_costs:
                Intent intent1 = new Intent(this, Activity_outcome.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.nav_income) {
            switch (item.getItemId()) {
                case R.id.nav_income:
                    Intent intent = new Intent(this, ActivityIncome.class);
                    startActivity(intent);
                    return true;

            }
            return true;

        } else
            if (id == R.id.nav_costs) {
                switch (item.getItemId()) {
                    case R.id.nav_costs:
                        Intent intent = new Intent(this, Activity_outcome.class);
                        startActivity(intent);
                        return true;

        } }else
            if (id == R.id.nav_categories_of_income) {
                switch (item.getItemId()) {
                    case R.id.nav_categories_of_income:
                        Intent intent = new Intent(this, Activity_categories_of_income.class);
                        startActivity(intent);
                        return true;
            }
        } else
            if (id == R.id.nav_expense_categories) {
                switch (item.getItemId()) {
                    case R.id.nav_expense_categories:
                        Intent intent = new Intent(this, Activity_categories_of_outcome.class);
                        startActivity(intent);
                        return true;
            }
        } else
            if (id == R.id.nav_report) {
                switch (item.getItemId()) {
                    case R.id.nav_report:
                        Intent intent = new Intent(this,  ActivityIncome.class);
                        startActivity(intent);
                        return true;
            }
        } else
            if (id == R.id.nav_statistic) {
                switch (item.getItemId()) {
                    case R.id.nav_statistic:
                        Intent intent = new Intent(this, ActivityIncome.class);
                        startActivity(intent);
                        return true;
                }

            }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

        }


    }

