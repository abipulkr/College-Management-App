package com.splash.user.first;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ce extends AppCompatActivity {

    ListView pdfListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce);

        pdfListView=(ListView)findViewById(R.id.myPDFList4);

        String[] pdfFiles={"1st Year Syllabus","2nd-4th Year Syllabus"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pdfFiles){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view=super.getView(position, convertView, parent);
                TextView myText=(TextView)view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdfListView.setAdapter(adapter);
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=pdfListView.getItemAtPosition(i).toString();
                Intent start=new Intent(getApplicationContext(),ceSyllabus.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });
    }
}
