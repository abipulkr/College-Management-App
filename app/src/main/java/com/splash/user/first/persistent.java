package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class persistent extends AppCompatActivity {

    PDFView persistent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent);

        persistent=findViewById(R.id.pdfViewer13);
        persistent.fromAsset("PERSISTENT-converted.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(persistent.this,campusDrive.class));
        finish();
    }
}
