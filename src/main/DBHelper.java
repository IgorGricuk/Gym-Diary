package com.example.gymdiary_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDBHelper44";
    public static final String TABLE_ORDER = "mytable99";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_NAME_EXERCISE = "nameExercise";
    public static final String KEY_EMAIL = "email";
    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(GymResultExercise.LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table " + TABLE_ORDER + " ("
                + " id integer primary key autoincrement,"
                + KEY_NAME + " text,"
                + KEY_NAME_EXERCISE + " text,"
                + KEY_EMAIL + " text"
                + ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_ORDER);
        onCreate(db);
    }
}


