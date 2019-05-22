package com.splash.user.first;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;


public class ConfirmPasswordActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    private EditText et_pass,et_cnf_pass;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper dbr;
    Context ctx = this;
    private String value;
    AwesomeText show_hide_ic,show_hide_ic1;
    boolean pwd_status = true;
    boolean pwd_status1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmpassword);

        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        show_hide_ic = (AwesomeText) findViewById(R.id.pwd_show_hide);
        show_hide_ic1 = (AwesomeText) findViewById(R.id.pwd_show_hide1);
        et_pass = (EditText) findViewById(R.id.ed_for_pass);
        et_cnf_pass = (EditText) findViewById(R.id.ed_for_cnf_pass);
        Button btn_reset = (Button) findViewById(R.id.btn_reset);

        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        value=bundle.getString("EMAIL");
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePassword();
            }
        });
        show_hide_ic.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {
                if (pwd_status) {
                    et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    show_hide_ic.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    et_pass.setSelection(et_pass.length());
                } else {
                    et_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    show_hide_ic.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    et_pass.setSelection(et_pass.length());

                }
            }
        });
        show_hide_ic1.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {
                if (pwd_status1) {
                    et_cnf_pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status1 = false;
                    show_hide_ic1.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    et_cnf_pass.setSelection(et_cnf_pass.length());
                } else {
                    et_cnf_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status1 = true;
                    show_hide_ic1.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    et_cnf_pass.setSelection(et_cnf_pass.length());

                }
            }
        });
    }
    private  void updatePassword() {

        String email = value;
        String value1 = et_pass.getText().toString().trim();
        String value2 = et_cnf_pass.getText().toString().trim();

        if (value1.isEmpty() && value2.isEmpty()){
            Toast.makeText(this, "fill all fields ", Toast.LENGTH_LONG).show();
            et_pass.setText("");
            et_cnf_pass.setText("");
            return;
        }

        if (!value1.contentEquals(value2)){
            et_cnf_pass.setError("Password doesn't match");
            et_cnf_pass.setText("");
            return;
        }
       if(!isValidPassword(value1))
       {

           et_pass.setError("Password must contain minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character");
           et_pass.setText("");
           return;
       }
       if(!isValidPassword(value2))
       {
           et_cnf_pass.setError("Password must contain minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character");
           et_cnf_pass.setText("");
           return;
       }
        if (!check(email)) {


            Toast.makeText(this, "email doesn't exist", Toast.LENGTH_LONG).show();
            et_pass.setText("");
            et_cnf_pass.setText("");
            return;

        } else {


            dbr=new DatabaseHelper(ctx);
           dbr.updateUserInfo(dbr,email,value1);

            Toast.makeText(this, "password reset successfully", Toast.LENGTH_SHORT).show();
            emptyInputEditText();
            Intent intent2 = new Intent(ConfirmPasswordActivity.this, MainActivity.class);
            startActivity(intent2);
            finish();
        }

    }

    private void emptyInputEditText()
    {
        et_pass.setText("");
        et_cnf_pass.setText("");
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
    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
