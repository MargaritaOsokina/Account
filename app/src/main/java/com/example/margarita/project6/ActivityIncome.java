package com.example.margarita.project6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ActivityIncome extends AppCompatActivity implements View.OnClickListener
{
    SQLiteDatabase db;
    DBHelper dbHelper;
    GridView gv_income;
    Button income_btnAdd;
    EditText income_money;
    SimpleCursorAdapter scAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        income_btnAdd = (Button) findViewById(R.id.income_btnAdd);
        income_btnAdd.setOnClickListener(this);

        income_money = findViewById(R.id.income_money);
        gv_income = findViewById(R.id.gv_income);
        gv_income= (GridView) findViewById(R.id.gv_income);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        showData();
        adjustGridView();


    }
    private void adjustGridView() {
        gv_income.setNumColumns(GridView.AUTO_FIT);
    }

    public void showData() {
        String[] from = new String[] { "_id", "cat_name" };
        Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.CATEGORIES + " WHERE type = " + DBHelper.TYPE_INCOME, null);
        int[] to = new int[] { R.id.id, R.id.income_money };// создааем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.income_item, c, from, to, 0);
        gv_income.setAdapter(scAdapter);

    }


   public void onClick(View v) {
        String cat = income_money.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.money, cat);
       contentValues.put("type", DBHelper.TYPE_INCOME);
        db.insert(DBHelper.CATEGORIES, null, contentValues);
        showData();

    }

}
