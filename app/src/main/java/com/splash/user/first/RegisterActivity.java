package com.splash.user.first;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.InputType;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class RegisterActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    EditText _txtname,_txtregno,_txtpass,_txtemail,_txtcnfpass;
    TextView _tvreg;
    AwesomeText show_hide_ic,show_hide_ic1;
    boolean pwd_status = true;
    boolean pwd_status1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        openHelper = new DatabaseHelper(this);
        _txtname = (EditText)findViewById(R.id.et_name);
        _txtregno = (EditText)findViewById(R.id.et_regno);
        _txtpass = (EditText)findViewById(R.id.et_pass);
        _txtemail = (EditText)findViewById(R.id.et_email);
        _btnreg = (Button) findViewById(R.id.btn_regis);
        _tvreg = (TextView) findViewById(R.id.tv_login_pg);
        _txtcnfpass= (EditText)findViewById(R.id.et_cnf_pass);
        show_hide_ic = (AwesomeText) findViewById(R.id.pwd_show_hide);
        show_hide_ic1 = (AwesomeText) findViewById(R.id.pwd_show_hide1);

        show_hide_ic.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {
                if (pwd_status) {
                    _txtpass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status = false;
                    show_hide_ic.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    _txtpass.setSelection(_txtpass.length());
                } else {
                    _txtpass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status = true;
                    show_hide_ic.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    _txtpass.setSelection(_txtpass.length());

                }
            }
        });
        show_hide_ic1.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View v) {
                if (pwd_status1) {
                    _txtcnfpass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwd_status1 = false;
                    show_hide_ic1.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    _txtcnfpass.setSelection( _txtcnfpass.length());
                } else {
                    _txtcnfpass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwd_status1 = true;
                    show_hide_ic1.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    _txtcnfpass.setSelection( _txtcnfpass.length());

                }
            }
        });


        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                db=openHelper.getWritableDatabase();
                String Name=_txtname.getText().toString();
                String Reg=_txtregno.getText().toString();
                String Pass=_txtpass.getText().toString();
                String Email=_txtemail.getText().toString();
                if(validate() && isEmailValid(Email) && isValidPassword(Pass) && isValidPassword1(_txtcnfpass.getText().toString()))
                {
                    insertData(Name, Reg, Pass, Email);
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                    startActivity( new Intent(RegisterActivity.this,MainActivity.class));  finish();
                }


            }
        });
        _tvreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(RegisterActivity.this,MainActivity.class));  finish();
            }
        });
    }
    public void insertData(String Name,String Reg_No,String Pass, String Email)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,Name);
        contentValues.put(DatabaseHelper.COL_3,Reg_No);
        contentValues.put(DatabaseHelper.COL_4,Email);
        contentValues.put(DatabaseHelper.COL_5,Pass);
        long id= db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

    }
    private Boolean validate()
    {
        Boolean result= false;
        String Name =  _txtname.getText().toString();
        String Pass =  _txtpass.getText().toString();
        String Reg =  _txtregno.getText().toString();
        String Email =  _txtemail.getText().toString();
        String CnfPass =  _txtcnfpass.getText().toString();
        if(Name.isEmpty() || Pass.isEmpty()|| Reg.isEmpty()|| Email.isEmpty())
        {
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
            _txtregno.setText("");
            _txtpass.setText("");
            _txtemail.setText("");
            _txtcnfpass.setText("");
            _txtname.setText("");
        }
        else
        {
            if (Pass.contentEquals(CnfPass)) {
                result=true;

            } else {
               _txtcnfpass.setError("Password doesn't match");
                _txtcnfpass.setText("");

            }
        }
        return result;

    }
    public boolean isEmailValid(String email)
    {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Boolean result= false;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
        {
            result= true;
        }
        else
        {
            _txtemail.setError("Invalid Email Format");
            _txtemail.setText("");

        }
        return result;
    }
    public boolean isValidPassword(final String password) {
        Boolean result= false;
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        //final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        if(matcher.matches())
        {
            result= true;
        }
        else
        {
            _txtpass.setError("Password must contain minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character");
            _txtpass.setText("");

        }
        return result;

    }
    public boolean isValidPassword1(final String password) {
        Boolean result= false;
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        //final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        if(matcher.matches())
        {
            result= true;
        }
        else
        {
            _txtcnfpass.setError("Password must contain minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character");
            _txtcnfpass.setText("");

        }
        return result;

    }
 }

