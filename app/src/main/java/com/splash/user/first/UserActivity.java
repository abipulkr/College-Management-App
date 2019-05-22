package com.splash.user.first;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class UserActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    JSONObject response, profile_pic_data, profile_pic_url;

    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView text=(TextView)findViewById(R.id.UserName);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView text1=(TextView)findViewById(R.id.textView);
        text1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserActivity.this,syllabus.class);
                startActivity(intent);
            }
        });

        log=findViewById(R.id.logout);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,MainActivity.class));
                finish();
            }
        });

        TextView text2=(TextView)findViewById(R.id.UserReg);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, post.class));
                finish();
            }
        });

        TextView text3=(TextView)findViewById(R.id.email);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,eNotice.class));
                finish();
            }
        });

        TextView text4=(TextView)findViewById(R.id.textView2);
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this,campusDrive.class));
                finish();
            }
        });

        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        /*Intent intent = getIntent();
        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        String value = bundle.getString("REGISTRATION_NUMBER");

        //Log.w("Jsondata", jsondata);
        FacebookSdk.sdkInitialize(getApplicationContext());
        TextView user_name = (TextView) findViewById(R.id.UserName);
        TextView user_reg = (TextView) findViewById(R.id.UserReg);
        ImageView user_picture = (ImageView) findViewById(R.id.profilePic);
        TextView user_email = (TextView) findViewById(R.id.email);
        try {

            String jsondata = intent.getStringExtra("userProfile");
            response = new JSONObject(jsondata);
            user_email.setText(response.get("email").toString());
            user_name.setText(response.get("name").toString());
            user_reg.setText(value);
            profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));
            Picasso.with(this).load(profile_pic_url.getString("url"))
                    .into(user_picture);

        } catch(Exception e){
            e.printStackTrace();
        }*/

    }

    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(this);

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

    public void userLogout(View view)
    {
        LoginManager.getInstance().logOut();
       startActivity( new Intent(this,MainActivity.class));
      finish();
    }
}
