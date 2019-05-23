package com.example.margarita.project6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Activity_categories_of_income extends AppCompatActivity {
    SQLiteDatabase db;
    DBHelper dbHelper;
    ListView catList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_of_income);

        catList = findViewById(R.id.citiesList);
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();


        Cursor c = db.rawQuery("SELECT * FROM categories;", null);
        String[] fields = {"_id", "cat_name", "type"};
        //int[] resIds = {R.id.id, R.id.city_name, R.id.country};
        //SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_categories_of_income, c, fields, resIds,0);
        //catList.setAdapter(adapter);

    }

    public void onClick(View v) {
        String cat = "";
        db.execSQL("INSERT INTO categories (_id, cat_name, type) VALUES ( 0)");

    }


}
