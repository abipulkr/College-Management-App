package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class bosch extends AppCompatActivity {

    PDFView bosch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosch);

        bosch=findViewById(R.id.pdfViewer10);
        bosch.fromAsset("BOSCH.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(bosch.this,campusDrive.class));
        finish();
    }
}
