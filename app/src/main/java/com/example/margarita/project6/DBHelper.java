package com.example.margarita.project6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "account.db";
    final static String CATEGORIES = "categories";
    final static String MONEY = "money";

    public static final String id = "_id";
    public static final String categor_name = "cat_name";
    public static final String money = "money";
    public static final int TYPE_INCOME = 1;
    public static final int TYPE_OUTCOME = 0;

    //public static final String KEY_MAIL = "mail";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ CATEGORIES + " (_id INTEGER PRIMARY KEY AUTOINCREMENT , cat_name TEXT NOT NULL, type INTEGER  NOT NULL)");
        db.execSQL("CREATE TABLE "+ MONEY + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, money FLOAT NOT NULL,  cat_id INTEGER NOT NULL )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + CATEGORIES);
        onCreate(db);
    }
}