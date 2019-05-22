package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class cts extends AppCompatActivity {

    PDFView cts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cts);

        cts=findViewById(R.id.pdfViewer8);
        cts.fromAsset("CTS.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(cts.this,campusDrive.class));
        finish();
    }
}
