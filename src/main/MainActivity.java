package com.example.gymdiary_1;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.NfcAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static int q;
    private Button button;
    private Button button2;
    private Button button3;
    private Spinner spinner;
    public static ArrayList selectedData = new ArrayList();
   String []data;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        spinner = (Spinner) findViewById(R.id.spinner);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        data=getResources().getStringArray(R.array.data);
        final SpinnerAdapter adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        ((ArrayAdapter<String>) adapter1).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,View view, int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
                String data1 = (String) adapter1.getItem(position);
                if(spinner.getSelectedItemPosition() != 0) {
                    selectedData.add(data1);
                }
                else{
                    selectedData.remove(data1);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                q = 1;
                intent = new Intent(MainActivity.this, GymSelection.class);
                startActivity(intent);
                break;
            case R.id.button2:
                q = 2;
                intent = new Intent(MainActivity.this, GymResultExercise.class);
                startActivity(intent);
                break;
            case R.id.button3:
                AlertDialog.Builder a_builder=new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Вы хотите закрыть приложение?")
                        .setCancelable(false)
                        .setPositiveButton("Да",new DialogInterface.OnClickListener() {
                            @Override
                            public  void onClick(DialogInterface dialog, int which){
                                finish();
                            }
                        })
                        .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert =a_builder.create();
                alert.setTitle("Закрытие приложения");
                alert.show();

        }

    }

}
