package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class sriram extends AppCompatActivity {

    PDFView sriram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sriram);

        sriram=findViewById(R.id.pdfViewer12);
        sriram.fromAsset("SRIRAM-converted.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(sriram.this,campusDrive.class));
        finish();
    }
}
