package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkingActivity extends AppCompatActivity {

    Button _btncheck;
    EditText _regno_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        _regno_check = (EditText)findViewById(R.id.et_chk_reg);
        _btncheck = (Button) findViewById(R.id.btn_check);
        _btncheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Reg =  _regno_check.getText().toString();
                if(isRegValid(Reg))
                {
                    Toast.makeText(getApplicationContext(), "Valid Registration Number", Toast.LENGTH_LONG).show();
                    Intent accountsIntent = new Intent(checkingActivity.this, UserActivity.class);
                    accountsIntent.putExtra("REGISTRATION_NUMBER",_regno_check.getText().toString().trim());
                    _regno_check.setText("");
                    startActivity(accountsIntent);
                    finish();
                }
                else
                {
                    _regno_check.setError("Invalid Registration Number");
                    _regno_check.setText("");
                    Toast.makeText(getApplicationContext(), " Invalid Registration Number", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
    public boolean isRegValid(String reg)
    {
        String expression = "[108]+[0-9]{8}";
        Boolean result= false;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(reg);
        if(matcher.matches())
        {
            result = true;
        }
        return result;
    }
}
