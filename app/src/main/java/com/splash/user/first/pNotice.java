package com.splash.user.first;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pNotice extends AppCompatActivity {
    EditText text1,text2;
    Button btn,btn_1;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_notice);

        myDb=new DatabaseHelper(this);
        text1=findViewById(R.id.editText2);
        text2=findViewById(R.id.editText3);
        btn=findViewById(R.id.button10);
        btn_1=findViewById(R.id.button11);
        AddData();

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),eNotice.class));
                finish();
            }
        });



    }

    public void AddData(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=myDb.insertData(text1.getText().toString(),text2.getText().toString());
                if(isInserted==true) {

                    Toast.makeText(pNotice.this, "Notice posted", Toast.LENGTH_LONG).show();
                    text1.setText("");
                    text2.setText("");

                }
                else {
                    Toast.makeText(pNotice.this, "Notice not posted", Toast.LENGTH_LONG).show();
                    text1.setText("");
                    text2.setText("");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(pNotice.this,UserActivity.class));
        finish();
    }
}
