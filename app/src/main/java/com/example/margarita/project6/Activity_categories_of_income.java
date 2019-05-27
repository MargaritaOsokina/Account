package com.example.margarita.project6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Activity_categories_of_income extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase db;
    DBHelper dbHelper;
    ListView income_cat;
    Button btnAdd;
    EditText cat_name;
    SimpleCursorAdapter scAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_of_income);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        cat_name = findViewById(R.id.cat_name);
        income_cat = findViewById(R.id.income_cat);
        income_cat= (ListView) findViewById(R.id.income_cat);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        showData();



    }
    public void showData() {
          String[] from = new String[] { "_id", "cat_name" };
        Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.CATEGORIES + " WHERE type = " + DBHelper.TYPE_INCOME, null);
        int[] to = new int[] { R.id.id, R.id.cat_name };// создааем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.category_item, c, from, to, 0);
        income_cat.setAdapter(scAdapter);

    }


    public void onClick(View v) {
        String cat = cat_name.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.categor_name, cat);
        contentValues.put("type", DBHelper.TYPE_INCOME);
        db.insert(DBHelper.CATEGORIES, null, contentValues);
        showData();

    }


}
