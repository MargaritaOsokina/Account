package com.example.margarita.project6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Activity_categories_of_outcome extends AppCompatActivity implements View.OnClickListener{

    SQLiteDatabase db;
    DBHelper dbHelper;
    ListView outcome_cat;
    Button out_btnAdd;
    EditText out_cat_name;
    SimpleCursorAdapter scAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_of_outcome);

        out_btnAdd = (Button) findViewById(R.id.out_btnAdd);
        out_btnAdd.setOnClickListener(this);

        out_cat_name = findViewById(R.id.out_cat_name);
        outcome_cat = findViewById(R.id.outcome_cat);
        outcome_cat= (ListView) findViewById(R.id.outcome_cat);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        showData();



    }
    public void showData() {
        String[] from = new String[] {  "cat_name" };
        Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.CATEGORIES + " WHERE type = " + DBHelper.TYPE_OUTCOME, null);
        int[] to = new int[] { R.id.out_cat_name };// создааем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.outcome_category_item, c, from, to, 0);
        outcome_cat.setAdapter(scAdapter);

    }


    public void onClick(View v) {
        String cat = out_cat_name.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.categor_name, cat);
        contentValues.put("type", DBHelper.TYPE_OUTCOME);
        db.insert(DBHelper.CATEGORIES, null, contentValues);
        showData();

    }


}
