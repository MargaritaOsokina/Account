package com.example.margarita.project6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Activity_statistics extends AppCompatActivity {


    SQLiteDatabase db;
    DBHelper dbHelper;
    GridView gvMain;
    GridView gvMain2;
    Button income_btnAdd;
    EditText income_money;
    SimpleCursorAdapter scAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);


        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        income_money = findViewById(R.id.income_money);
        gvMain = findViewById(R.id.gvMain);
        gvMain= (GridView) findViewById(R.id.gvMain);

        gvMain2 = findViewById(R.id.gvMain2);
        gvMain2= (GridView) findViewById(R.id.gvMain2);
        showData();
        adjustGridView();

    }


    public void showData() {
        String[] from = new String[] {  "cat_name" };
        Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.CATEGORIES + " WHERE type = " + DBHelper.TYPE_INCOME, null);
        int[] to = new int[] { R.id.tvText };// создааем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.statistics_item, c, from, to, 0);
        gvMain.setAdapter(scAdapter);
        gvMain2.setAdapter(scAdapter);}
    private void adjustGridView() {
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain2.setNumColumns(GridView.AUTO_FIT);

    }}