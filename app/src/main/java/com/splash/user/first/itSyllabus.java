package com.splash.user.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class itSyllabus extends AppCompatActivity {

    PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_syllabus);

        myPDFViewer=(PDFView)findViewById(R.id.pdfViewer1);
        String getItem=getIntent().getStringExtra("pdfFileName");
        if(getItem.equals("1st Year Syllabus")){
            myPDFViewer.fromAsset("1st_year_syllabus.pdf").load();
        }
        if(getItem.equals("2nd-4th Year Syllabus")){
            myPDFViewer.fromAsset("IT_syllabus.pdf").load();
        }
    }
}
