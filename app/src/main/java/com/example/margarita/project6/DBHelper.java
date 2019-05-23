package com.example.margarita.project6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "account.db";
    final static String TABLE_NAME = "categories";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " (_id INT PRIMARY KEY AUTO_INCREMENT, cat_name VARCHAR(30) NOT NULL, type INT  NOT NULL)");
        //db.execSQL("INSERT INTO "+ TABLE_NAME + "
        db.execSQL("INSERT INTO "+ TABLE_NAME + " VALUES (2, \"Trasport\", 0);");
        db.execSQL("INSERT INTO "+ TABLE_NAME + " VALUES (5, \"Service\", 0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}