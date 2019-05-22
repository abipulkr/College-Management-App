package com.splash.user.first;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.widget.VideoView;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;





public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    TextView userRegistration,_tv_for;
    Button _btnlog;

    EditText _txtregno,_txtpass;
    Cursor cursor;
    private VideoView mVideoView;
    private SharedPreferenceConfig sharedPreferenceConfig;
    CallbackManager callbackManager;
    AwesomeText show_hide_ic;
    boolean pwd_status = true;
   // private static final String EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // callbackManager = CallbackManager.Factory.create();
        //LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        //loginButton.setReadPermissions("email");
        //loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            /*@Override
            public void onSuccess(LoginResult loginResult) {
                getUserDetails(loginResult);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });*/



        show_hide_ic = (AwesomeText) findViewById(R.id.pwd_show_hide);
       sharedPreferenceConfig= new SharedPreferenceConfig(getApplicationContext());

        mVideoView = (VideoView) findViewById(R.id.bgvideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vd3);
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        userRegistration = (TextView)findViewById(R.id.tv_reg);
        _txtregno = (EditText)findViewById(R.id.et_reg);
        _txtpass = (EditText)findViewById(R.id.et_pass);
        _btnlog = (Button) findViewById(R.id.btn_login);
        _tv_for=(TextView)findViewById(R.id.tv_for);

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

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity( new Intent(MainActivity.this,RegisterActivity.class));  finish();
            }
        });
        _tv_for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity( new Intent(MainActivity.this,ForgotPasswordActivity.class));  finish();
            }
        });

       /* if(sharedPreferenceConfig.readLoginStatus())
        {
            startActivity( new Intent(MainActivity.this,UserActivity.class));
            finish();
        }*/
    }



   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }*/

    /*protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject json_object,
                            GraphResponse response) {
                        Intent intent = new Intent(MainActivity.this, checkingActivity.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);
                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

    }

    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }*/



    public void LoginUser(View view) {
        String Reg_No=_txtregno.getText().toString();
        String Pass=_txtpass.getText().toString();
        if(isValidPassword(Pass)) {
            cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_3 + " = '" + Reg_No + "' and " + DatabaseHelper.COL_5 + " = '" + Pass + "'", null);
            if (cursor != null) {
                // progressDialog.setMessage("Authenticating wait for 10 seconds!!");
                // progressDialog.show();
                if (cursor.getCount() > 0) {
                    //  progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, UserActivity.class));
                    sharedPreferenceConfig.writeLoginStatus(true);
                    finish();
                } else {
                    // progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_LONG).show();
                    _txtregno.setText("");
                    _txtpass.setText("");
                }
            }
        }
        else
        {
            _txtpass.setError("Password must contain minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character");
            _txtpass.setText("");
        }
    }
    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        //final String PASSWORD_PATTERN = "";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }

     @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle(R.string.exit);
        builder.setMessage(R.string.exit_message);

        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog=builder.show();
    }


}
