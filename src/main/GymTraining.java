package com.example.gymdiary_1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GymTraining extends AppCompatActivity {
private Chronometer chronometer;
private long pauseoffset;
private boolean running;
private Button result;
private ImageButton revert;
private ImageButton play;
private ImageButton pause;
private ImageButton reset;
private ImageButton nextapproach;
private ImageView imageView;
public static int a=0;
    public static ArrayList selectedChronometer = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_training);

        imageView = findViewById(R.id.imageView4);
        revert=findViewById(R.id.revert);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        reset = findViewById(R.id.reset);
        nextapproach = findViewById(R.id.nextapproach);
        result=findViewById(R.id.result);
        chronometer=findViewById(R.id.chronometer);

        switch(GymSelection.k){
            case 1:
                imageView.setImageResource(R.drawable.berpi);
                break;
            case 2:
                imageView.setImageResource(R.drawable.run);
                break;
            case 3:
                imageView.setImageResource(R.drawable.exercisebike);
                break;
            case 4:
                imageView.setImageResource(R.drawable.strap);
                break;
            case 5:
                imageView.setImageResource(R.drawable.jumpingrope);
                break;
            case 6:
                imageView.setImageResource(R.drawable.rockfish);
                break;
            case 7:
                imageView.setImageResource(R.drawable.exercisebike);
                break;
            case 8:
                imageView.setImageResource(R.drawable.pushup);
                break;
            case 9:
                imageView.setImageResource(R.drawable.exercisebike);
                break;
        }

        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 1000000000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(GymTraining.this, "Bing!", Toast.LENGTH_SHORT);
                }
            }
        });

        revert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GymTraining.this, GymSelection.class);
                startActivity(intent);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    chronometer.stop();
                    running = false;
                }
            }
        });        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!running) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
                    chronometer.start();
                    running = true;
                }
            }
        });
       reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseoffset = 0;
            }
        });
        nextapproach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Время добавлено" , Toast.LENGTH_SHORT).show();
             String a= (String) chronometer.getText().toString();
             selectedChronometer.add(a);

            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GymTraining.this,GymResultExercise.class);
                startActivity(intent);

            }
        });
    }
}
