package com.example.gymdiary_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

public class GymDescription extends AppCompatActivity {
private ImageButton revert2;
private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_description);
        imageView=findViewById(R.id.imageView);
        revert2=findViewById(R.id.revert2);
        revert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GymDescription.this,GymSelection.class);
                startActivity(intent);
            }
        });

        switch (GymSelection.r){
            case 1:imageView.setImageResource(R.drawable.berpi_description);
                break;
            case 2:imageView.setImageResource(R.drawable.run_description);
                break;
            case 3:imageView.setImageResource(R.drawable.exercisebike_description);
                break;
            case 4:imageView.setImageResource(R.drawable.berpi_description);
                break;
            case 5:imageView.setImageResource(R.drawable.berpi_description);
                break;
            case 6:imageView.setImageResource(R.drawable.berpi_description);
                break;
            case 7:imageView.setImageResource(R.drawable.berpi_description);
                break;
            case 8:imageView.setImageResource(R.drawable.berpi_description);
                break;
            case 9:imageView.setImageResource(R.drawable.berpi_description);
                break;
        }
    }

}
