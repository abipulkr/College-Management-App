package com.splash.user.first;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class eNotice extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_notice);

        myDb=new DatabaseHelper(this);
        TextView text=(TextView)findViewById(R.id.textView3);
        Cursor cursor=myDb.ViewData();

        StringBuilder stringBuilder=new StringBuilder();
        while(cursor.moveToNext()){
            stringBuilder.append("\nSNo: "+cursor.getString(0)+"\nDate: "+cursor.getString(1)+"\nNotice: "+cursor.getString(2)+"\n\n");
        }
        text.setText(stringBuilder);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(eNotice.this,UserActivity.class));
        finish();
    }
}
