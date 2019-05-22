package com.splash.user.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class mindtree extends AppCompatActivity {

    PDFView mind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindtree);

        mind=findViewById(R.id.pdfViewer11);
        mind.fromAsset("MINDTREE.pdf").load();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(mindtree.this,campusDrive.class));
        finish();
    }
}
