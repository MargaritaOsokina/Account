package com.example.margarita.project6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Activity_statistics extends AppCompatActivity {

    String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    GridView gvMain;
    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        adapter = new ArrayAdapter<String>(this, R.layout.statistics_item,R.id.tvText,data);
        gvMain = (GridView) findViewById(R.id.gvMain);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }


    private void adjustGridView() {
        gvMain.setNumColumns(GridView.AUTO_FIT);
    }
}