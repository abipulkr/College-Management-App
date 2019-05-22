package com.splash.user.first;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class campusDrive extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8;
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_drive);

        myLayout=(ConstraintLayout)findViewById(R.id.myLayout5);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        b1=findViewById(R.id.tcs);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,tcs.class));
                finish();
            }
        });

        b2=findViewById(R.id.cts);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,cts.class));
                finish();
            }
        });

        b3=findViewById(R.id.cgi);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,cgi.class));
                finish();
            }
        });

        b4=findViewById(R.id.bosch);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,bosch.class));
                finish();
            }
        });

        b5=findViewById(R.id.mindtree);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,mindtree.class));
                finish();
            }
        });

        b6=findViewById(R.id.sriram);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,sriram.class));
                finish();
            }
        });

        b7=findViewById(R.id.persistent);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,persistent.class));
                finish();
            }
        });

        b8=findViewById(R.id.test);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(campusDrive.this,StartingScreenActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(campusDrive.this,UserActivity.class));
        finish();
    }
}
