//package com.example.gymdiary_1;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//
//
//public class DB {
//
//    private static final String DB_NAME = "mydb";
//    private static final int DB_VERSION = 1;
//    private static final String DB_TABLE = "mytab";
//
//    public static final String COLUMN_ID = "_id";
//    public static final String COLUMN_DATA = "data";
//    public static final String COLUMN_NAME = "name";
//    public static final String COLUMN_CHRONOMETER = "chronometer";
//
//    private static final String DB_CREATE =
//            "create table " + DB_TABLE + "(" +
//                    COLUMN_ID + " integer primary key autoincrement, " +
//                    COLUMN_DATA + " text, " +
//                    COLUMN_NAME + " text, " +
//                    COLUMN_CHRONOMETER + " text" +
//                    ");";
//
//    private final Context mCtx;
//    private DBHelper mDBHelper;
//    private SQLiteDatabase mDB;
//
//    public DB(Context ctx) {
//        mCtx = ctx;
//    }
//
//    // открыть подключение
//    public void open() {
//        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
//        mDB = mDBHelper.getWritableDatabase();
//    }
//
//    // закрыть подключение
//    public void close() {
//        if (mDBHelper!=null) mDBHelper.close();
//    }
//    // получить все данные из таблицы DB_TABLE
//    public Cursor getAllData() {
//        return mDB.query(DB_TABLE, null, null, null, null, null, null);
//    }
//
//    // добавить запись в DB_TABLE
//    public void addRec() {
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_DATA, String.valueOf(MainActivity.selectedData));
//        cv.put(COLUMN_NAME, String.valueOf(GymResultExercise.nameExercise));
//        cv.put(COLUMN_CHRONOMETER, String.valueOf(GymTraining.selectedChronometer));
//        mDB.insert(DB_TABLE, null, cv);
//    }
//
//    // удалить запись из DB_TABLE
//    public void delRec() {
//        mDB.delete(DB_TABLE, null, null);
//    }
//
//    // класс по созданию и управлению БД
//    private class DBHelper extends SQLiteOpenHelper {
//
//        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
//                        int version) {
//            super(context, name, factory, version);
//        }
//
//        // создаем и заполняем БД
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            db.execSQL(DB_CREATE);
//
//                ContentValues cv = new ContentValues();
//                cv.put(COLUMN_DATA, String.valueOf(MainActivity.selectedData));
//                cv.put(COLUMN_NAME, String.valueOf(GymResultExercise.nameExercise));
//                cv.put(COLUMN_CHRONOMETER, String.valueOf(GymTraining.selectedChronometer));
//                db.insert(DB_TABLE, null, cv);
//
//        }
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        }
//    }
//}
