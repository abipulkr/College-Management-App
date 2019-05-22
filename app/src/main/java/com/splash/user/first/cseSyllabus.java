package com.splash.user.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class cseSyllabus extends AppCompatActivity {

    PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_syllabus);

        myPDFViewer=(PDFView)findViewById(R.id.pdfViewer);
        String getItem=getIntent().getStringExtra("pdfFileName");
        if(getItem.equals("1st Year Syllabus")){
            myPDFViewer.fromAsset("1st_year_syllabus.pdf").load();
        }
        if(getItem.equals("2nd-4th Year Syllabus")){
            myPDFViewer.fromAsset("CSE_syllabus.pdf").load();
        }
    }
}
