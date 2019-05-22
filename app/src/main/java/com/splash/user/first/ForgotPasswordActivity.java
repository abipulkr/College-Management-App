package com.splash.user.first;

import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    private EditText et_email;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        et_email = (EditText) findViewById(R.id.ed_email);
        Button btn_cnf = (Button) findViewById(R.id.btn_forget);


        setTitle("Recover password");
        btn_cnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyFromSQLite();
            }

        });

        }
    private void verifyFromSQLite()
    {

        if (et_email.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill your email", Toast.LENGTH_SHORT).show();
            emptyInputEditText();
            return;
        }

       else
        {
            if(isEmailValid(et_email.getText().toString()))
            {
                if (check(et_email.getText().toString().trim())) {
                    Intent accountsIntent = new Intent(this, ConfirmPasswordActivity.class);
                    accountsIntent.putExtra("EMAIL", et_email.getText().toString().trim());
                    emptyInputEditText();
                    startActivity(accountsIntent);
                    finish();
                } else {
                    Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                    emptyInputEditText();
                }
            }
            else
            {
                et_email.setError("Invalid Email Format");
                et_email.setText("");

            }
        }
    }
    public boolean isEmailValid(String email)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private void emptyInputEditText(){
        et_email.setText("");
    }
    private boolean check(String email){
        String[] columns = {
                DatabaseHelper.COL_1
        };
        openHelper = new DatabaseHelper(this);
        db = openHelper.getWritableDatabase();

        String selection = DatabaseHelper.COL_4 + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        return cursorCount > 0;

    }
    }



