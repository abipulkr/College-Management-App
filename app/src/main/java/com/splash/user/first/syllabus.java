package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class syllabus extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(syllabus.this,cse.class);
                startActivity(int2);
            }
        });
        b2=(Button)findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3=new Intent(syllabus.this,it.class);
                startActivity(int3);
            }
        });
        b3=(Button)findViewById(R.id.button4);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4=new Intent(syllabus.this,ece.class);
                startActivity(int4);
            }
        });
        b4=(Button)findViewById(R.id.button5);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5=new Intent(syllabus.this,ee.class);
                startActivity(int5);
            }
        });
        b5=(Button)findViewById(R.id.button6);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6=new Intent(syllabus.this,ce.class);
                startActivity(int6);
            }
        });
        b6=(Button)findViewById(R.id.button7);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int7=new Intent(syllabus.this,me.class);
                startActivity(int7);
            }
        });
        b7=(Button)findViewById(R.id.button8);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int8=new Intent(syllabus.this,aeie.class);
                startActivity(int8);
            }
        });
    }
}