package com.example.gymdiary_1;
import android.content.ClipData;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.gymdiary_1.R.layout.results;

public class GymResultExercise extends AppCompatActivity implements View.OnClickListener {
    public static String LOG_TAG = "myLogs";
    private ImageButton revert3;
    private Button add;
    private Button deletelist;
    private Button read;
    ListView listView;
    Cursor cursor;
    DBHelper dbHelper;
    ArrayList ResultExrecise = new ArrayList();
    public static ArrayList nameExercise = new ArrayList();
    int a=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_result_exercise);

        revert3 = (ImageButton) findViewById(R.id.revert3);
        add = (Button) findViewById(R.id.add);
        deletelist = (Button) findViewById(R.id.deletelist);
        listView = (ListView) findViewById(R.id.listview);
        read=(Button) findViewById(R.id.read);

        read.setOnClickListener(this);
        revert3.setOnClickListener(this);
        add.setOnClickListener(this);
        deletelist.setOnClickListener(this);
        dbHelper=new DBHelper(this);

        nameExercise.remove(nameExercise);
        ResultExrecise.remove(ResultExrecise);
        GymTraining.selectedChronometer.remove(GymTraining.selectedChronometer);
        MainActivity.selectedData.remove(MainActivity.selectedData);

        switch (GymSelection.nameexercise) {
            case 1:
                nameExercise.add("Берпи");
                break;
            case 2:
                nameExercise.add("Прыжки на месте с высоко поднятыми колениями");
                break;
            case 3:
                nameExercise.add("Упражнение Велосипед");
                break;
            case 4:
                nameExercise.add("Планка");
                break;
            case 5:
                nameExercise.add("Прыжки со скакалкой ");
                break;
            case 6:
                nameExercise.add("Скалалаз");
                break;
            case 7:
                nameExercise.add("Велосипед");
                break;
            case 8:
                nameExercise.add("Отжимание от пола");
                break;
            case 9:
                nameExercise.add("Скакалка");
                break;
            default:
                break;
        }
    }
    @Override
    public void onClick(View v) {
      SQLiteDatabase db = dbHelper.getWritableDatabase();
       ContentValues cv  =new ContentValues();
      //  nameExercise.remove(nameExercise);
        switch (v.getId()) {
            case R.id.add:
                Toast.makeText(getBaseContext(), "Добавлено" , Toast.LENGTH_SHORT).show();
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                // подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put(DBHelper.KEY_NAME,String.valueOf(MainActivity.selectedData));
                cv.put(DBHelper.KEY_NAME_EXERCISE,String.valueOf(nameExercise));
                cv.put(DBHelper.KEY_EMAIL,String.valueOf(GymTraining.selectedChronometer));
                // вставляем запись и получаем ее ID
                long rowID;
                rowID = db.insert(DBHelper.TABLE_ORDER,null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.read:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
                 // делаем запрос всех данных из таблицы mytable, получаем Cursor
                 cursor = db.query(DBHelper.TABLE_ORDER,null , null, null, null, null, null);
               //  startManagingCursor(cursor);

            if(cursor.moveToFirst()){
                int idIndex = cursor.getColumnIndex("id");
                int nameColIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int nameExerciseColIndex = cursor.getColumnIndex(DBHelper.KEY_NAME_EXERCISE);
                int emailColIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
                do {
                    if(a==0)
                    ResultExrecise.add(cursor.getInt(idIndex));
                        ResultExrecise.add(cursor.getString(nameColIndex));
                        ResultExrecise.add(cursor.getString(nameExerciseColIndex));
                        ResultExrecise.add(cursor.getString(emailColIndex));
                    Log.d(LOG_TAG,
                            "ID = " + cursor.getInt(idIndex) +
                                    ", name = " + cursor.getString(nameColIndex) +
                                    ", nameExercise = " + cursor.getString(nameExerciseColIndex) +
                                    ", email = " + cursor.getString(emailColIndex));
                }while(cursor.moveToNext());
            }else
                Log.d(LOG_TAG, "0 rows");
                  cursor.close();
                 //   nameExercise.remove(nameExercise);
              Adapter adapter=new ArrayAdapter<String>(this,R.layout.results,ResultExrecise);
               listView.setAdapter((ListAdapter) adapter);
                break;
            case R.id.deletelist:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                //удаляем все записи
                int clearCount = db.delete(DBHelper.TABLE_ORDER, null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                cv.clear();
                Intent intent = new Intent(this, GymResultExercise.class);
                startActivity(intent);
                break;
            case R.id.revert3:
                cursor.close();
                db.close();
                cursor.close();
                cv.clear();
                dbHelper.close();
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                break;
        }
        dbHelper.close();
    }
}

