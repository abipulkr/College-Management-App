package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class post extends AppCompatActivity {

    EditText id;
    Button verify;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper dbr;
    Cursor cursor;
    private SharedPreferenceConfig sharedPreferenceConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        id=findViewById(R.id.editText);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        verify=findViewById(R.id.button9);
        LoginUser(verify);

    }
    public void LoginUser(View view) {
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Reg_No=id.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_3 + " = '" + Reg_No + "'", null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        String expression = "AECP1234567";
                        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(Reg_No);
                        if(matcher.matches()) {
                            Toast.makeText(getApplicationContext(), "Verified", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(post.this, pNotice.class));
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Only Principal can post", Toast.LENGTH_LONG).show();
                            id.setText("");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Id", Toast.LENGTH_LONG).show();
                        id.setText("");
                    }
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(post.this,UserActivity.class));
        finish();
    }
}
