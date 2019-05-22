package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class cgi extends AppCompatActivity {

    PDFView cgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgi);

        cgi=findViewById(R.id.pdfViewer9);
        cgi.fromAsset("CGI.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(cgi.this,campusDrive.class));
        finish();
    }
}
