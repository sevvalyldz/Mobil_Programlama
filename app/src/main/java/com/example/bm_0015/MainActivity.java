package com.example.bm_0015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button bttn_merhaba;

    Button bttn_merhaba2;
    Button bttn_merhaba3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttn_merhaba=findViewById(R.id.bttn_merhaba);
        bttn_merhaba2=findViewById(R.id.bttn_merhaba2);
        bttn_merhaba3=findViewById(R.id.bttn_merhaba3);

        bttn_merhaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, SetupActivity2.class);
                startActivity(i);

            }
        });
        bttn_merhaba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, SetupActivity3.class);
                startActivity(i);

            }
        });
        bttn_merhaba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, SetupActivity4.class);
                startActivity(i);

            }
        });






    }


}