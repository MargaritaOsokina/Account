package com.example.margarita.project6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Activity_categories_of_income extends AppCompatActivity {
    SQLiteDatabase db;
    DBHelper dbHelper;
    ListView citiesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_of_income);

        citiesList = findViewById(R.id.citiesList);
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM cities;", null);
        String[] fields = {"_id", "name", "country"};
        int[] resIds = {R.id.new_categories};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_categories_of_income, c, fields, resIds,0);
        citiesList.setAdapter(adapter);

    }

}
