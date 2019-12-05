package com.example.gymdiary_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.nio.channels.Channels;

public class GymSelection extends AppCompatActivity implements View.OnClickListener {
    private ImageButton revert1;
    private Button berpi;
    private Button run;
    private Button exercisebike;
    private Button strap;
    private Button jumpingrope;
    private Button rockfish;
    private Button button11;
    private Button pushup;
    private Button skakalka;
    public static int k;
    public  static  int r;
    public static int nameexercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_selection);


        revert1 = findViewById(R.id.revert1);
        berpi = findViewById(R.id.berpi);
        run = findViewById(R.id.run);
        exercisebike = findViewById(R.id.exercisebike);
        strap = findViewById(R.id.strap);
        jumpingrope = findViewById(R.id.jumpingrope);
        rockfish = findViewById(R.id.rockfish);
        button11 = findViewById(R.id.button11);
        pushup = findViewById(R.id.pushup);
        skakalka = findViewById(R.id.skakalka);

        revert1.setOnClickListener(this);
        berpi.setOnClickListener(this);
        run.setOnClickListener(this);
        exercisebike.setOnClickListener(this);
        strap.setOnClickListener(this);
        jumpingrope.setOnClickListener(this);
        rockfish.setOnClickListener(this);
        button11.setOnClickListener(this);
        pushup.setOnClickListener(this);
        skakalka.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.revert1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.berpi:
                nameexercise=1;
                switch (MainActivity.q) {
                    case 1:
                        k = 1;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=1;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.run:
                nameexercise=2;
                switch (MainActivity.q) {
                    case 1:
                        k = 2;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=2;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.exercisebike:
                nameexercise=3;
                switch (MainActivity.q) {
                    case 1:
                        k = 3;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=3;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.strap:
                nameexercise=4;
                switch (MainActivity.q) {
                    case 1:
                        k = 4;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=4;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.jumpingrope:
                nameexercise=5;
                switch (MainActivity.q) {
                    case 1:
                        k = 5;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=5;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.rockfish:
                nameexercise=6;
                switch (MainActivity.q) {
                    case 1:
                        k = 6;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=6;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.button11:
                nameexercise=7;
                switch (MainActivity.q) {
                    case 1:
                        k = 7;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=7;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.pushup:
                nameexercise=8;
                switch (MainActivity.q) {
                    case 1:
                        k = 8;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=8;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
            case R.id.skakalka:
                nameexercise=9;
                switch (MainActivity.q) {
                    case 1:
                        k = 9;
                        intent = new Intent(this, GymTraining.class);
                        startActivity(intent);
                        break;
                    case 2:
                        r=9;
                        intent = new Intent(this, GymDescription.class);
                        startActivity(intent);
                        break;
                }break;
        }
    }
}