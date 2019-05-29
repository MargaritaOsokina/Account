package com.example.margarita.project6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.sql.SQLData;

public class Activity_outcome extends AppCompatActivity  implements View.OnClickListener
{
    SQLiteDatabase db;
    DBHelper dbHelper;
    GridView gv_outcome;
    Button outcome_btnAdd;
    EditText outcome_money;
    SimpleCursorAdapter scAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome);

        outcome_btnAdd = (Button) findViewById(R.id.outcome_btnAdd);
        outcome_btnAdd.setOnClickListener(this);

        outcome_money = findViewById(R.id.outcome_money);
        gv_outcome = findViewById(R.id.gv_outcome);
        gv_outcome= (GridView) findViewById(R.id.gv_outcome);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        showData();
        adjustGridView();

    }
    private void adjustGridView() {
        gv_outcome.setNumColumns(GridView.AUTO_FIT);
    }

    public void showData() {
        String[] from = new String[] { "_id", "cat_name" };
        Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.CATEGORIES + " WHERE type = " + DBHelper.TYPE_OUTCOME, null);
        int[] to = new int[] { R.id.id, R.id.outcome_money };// создааем адаптер и настраиваем список
        scAdapter = new SimpleCursorAdapter(this, R.layout.outcome_item, c, from, to, 0);
        gv_outcome.setAdapter(scAdapter);

    }


    public void onClick(View v) {
        String cat = outcome_money.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.money, cat);
        contentValues.put("type", DBHelper.TYPE_OUTCOME);
        db.insert(DBHelper.CATEGORIES, null, contentValues);
        showData();

    }

}


