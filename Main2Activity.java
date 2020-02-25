package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView textMessage;
    String str, message;
    Button pushc,fullc,lowerc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textMessage = findViewById(R.id.text2);
        message = getIntent().getStringExtra("message_key");
        pushc=findViewById(R.id.pushchecked);
        fullc=findViewById(R.id.fullchecked);
        lowerc=findViewById(R.id.lowerchecked);

        pushc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openpush();
                    }
                });
        fullc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openfull();
                    }
                });
        lowerc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openlower();
                    }
                });

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 12)
            str = "Good Morning,";
        else if (hour >= 12 && hour < 18)
            str = "Good afternoon,";
        else if (hour >= 18 && hour < 22)
            str = "Good evening,";
        else str = "Good night,";
        textMessage.setText(str + " " + message);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pushchecked:
                openpush();
                break;
            case R.id.lowerchecked:
                openlower();
                break;
            case R.id.fullchecked:
                openfull();
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }

    }


    public void openpush(){
        Intent push=new Intent(this,PushActivity.class);
        startActivity(push);
    }
    public void openlower(){
        Intent lower=new Intent(this,LowerActivity.class);
        startActivity(lower);
    }
    public void openfull(){
        Intent full=new Intent(this,FullActivity.class);
        startActivity(full);
    }
}