package com.example.sofe4640.xmlparser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void runParser(View v){
        Intent intent= new Intent(this,XmlParser.class);
        startActivity(intent);
    }
}
