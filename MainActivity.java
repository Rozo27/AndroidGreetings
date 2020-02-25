package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText nume1;
    TextView text1;
    String yourName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nume1 = findViewById(R.id.nume1);
        nume1.setGravity(Gravity.CENTER_HORIZONTAL);//aliniaza textul input pe mijloc in contrast cu default ul care pleca de la stanga
        text1=findViewById(R.id.text1);

        button=findViewById(R.id.buttonNext);
        //verifica daca a fost introdus numele. altfel nu trece la next activity

        if( TextUtils.isEmpty(nume1.getText())){


            nume1.setError( "Your name is required!" );

        }
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openactivity2();
                }
            });


    }
    public void  openactivity2()
    {Intent i = new Intent(this, Main2Activity.class);
    yourName = nume1.getText().toString();
    i.putExtra("message_key", yourName);
    startActivity(i);

    }


}
