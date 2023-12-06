package com.example.bm_0015;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetupActivity4 extends AppCompatActivity {


    EditText editText_no;
    EditText editText_msj;
    Button bttn_gndr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup4);
        editText_no=findViewById(R.id.editText_no);
        editText_msj=findViewById(R.id.editText_msj);
        bttn_gndr=findViewById(R.id.bttn_gndr);

        bttn_gndr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText_no.getText().toString();
                String msg=editText_msj.getText().toString();
                try {
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,msg,null,null);
                    Toast.makeText(getApplicationContext(), "Mesaj gönderildi", Toast.LENGTH_SHORT).show();
                }
                catch (Exception a)
                {
                    Toast.makeText(getApplicationContext(), "Mesaj gönderilemedi", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}