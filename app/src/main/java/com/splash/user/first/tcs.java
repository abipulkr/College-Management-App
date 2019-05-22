package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class tcs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcs);

        PDFView tcs=findViewById(R.id.pdfViewer7);
        tcs.fromAsset("TCS.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(tcs.this,campusDrive.class));
        finish();
    }
}
