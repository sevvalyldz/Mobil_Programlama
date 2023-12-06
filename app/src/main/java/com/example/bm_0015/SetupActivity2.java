package com.example.bm_0015;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class SetupActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView editText_dcml;
    TextView textSonuc_dcml;
    Spinner spinner_dcml;
    Integer dcml_input;
    Double dcml2_input;
    Double cel_input;


    TextView editText_dcml2;
    TextView textSonuc_dcml2;
    Spinner spinner2_dcml;

    TextView editText_cel;
    TextView textSonuc_cel;
    RadioGroup radioGroup;
    RadioButton rb1;
    RadioButton rb2;

    String[] dcml_items = { "Seçiniz","Binary","Octal","HexaDecimal"};
    String[] dcml_items2 = { "Seçiniz","kilo byte","byte","kibi byte","bit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup2);
        editText_dcml=findViewById(R.id.editText_dcml);
        textSonuc_dcml=findViewById(R.id.textSonuc_dcml);
        spinner_dcml=findViewById(R.id.spinner_dcml);
        editText_dcml2=findViewById(R.id.editText_dcml2);
        textSonuc_dcml2=findViewById(R.id.textSonuc_dcml2);
        spinner2_dcml=findViewById(R.id.spinner2_dcml);
        textSonuc_cel=findViewById(R.id.textSonuc_cel);
        editText_cel=findViewById(R.id.editText_cel);
        radioGroup=findViewById(R.id.radioGroup);
        rb1=findViewById(R.id.rb1_fah);
        rb2=findViewById(R.id.rb2_kel);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rb1.getId()==checkedId){
                    cel_input=Double.parseDouble((String) editText_cel.getText().toString());
                    cel_input=(cel_input*((9/5)+32));
                    textSonuc_cel.setText(Double.toString(cel_input)+"F");

                } else if (rb2.getId()==checkedId) {

                    cel_input=Double.parseDouble((String) editText_cel.getText().toString());
                    cel_input=(cel_input+273.15);
                    textSonuc_cel.setText(Double.toString(cel_input)+"K");
                }

                }


            });


        spinner_dcml.setOnItemSelectedListener(this);
        ArrayAdapter ad_dcml
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                dcml_items);
        ad_dcml.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinner_dcml.setAdapter(ad_dcml);
        spinner2_dcml.setOnItemSelectedListener(this);

        ArrayAdapter ad_dcml2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                dcml_items2);
        ad_dcml2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spinner2_dcml.setAdapter(ad_dcml2);




    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.spinner_dcml){
            switch (position){
                case 0:
                    break;
                case 1:
                    dcml_input=Integer.parseInt(editText_dcml.getText().toString());
                    textSonuc_dcml.setText(Integer.toBinaryString(dcml_input));
                    break;
                case 2:
                    dcml_input=Integer.parseInt(editText_dcml.getText().toString());
                    textSonuc_dcml.setText(Integer.toOctalString(dcml_input));
                    break;
                case 3:
                    dcml_input=Integer.parseInt(editText_dcml.getText().toString());
                    textSonuc_dcml.setText(Integer.toHexString(dcml_input));
                    break;

            }

            } else if (parent.getId()==R.id.spinner2_dcml){
                switch (position){
                    case 0:
                        break;
                    case 1:
                        dcml2_input=Double.parseDouble(editText_dcml2.getText().toString());
                        double kilobyteSonuc=dcml2_input * 1024;
                        textSonuc_dcml2.setText(Double.toString(kilobyteSonuc));
                        break;
                    case 2:
                        dcml2_input=Double.parseDouble(editText_dcml2.getText().toString());
                        double byteSonuc=dcml2_input * 1_048_576;
                        textSonuc_dcml2.setText(Double.toString(byteSonuc));
                        break;
                    case 3:
                        dcml2_input=Double.parseDouble(editText_dcml2.getText().toString());
                        double kibibyteSonuc=dcml2_input * 976_5625;
                        textSonuc_dcml2.setText(Double.toString(kibibyteSonuc));
                        break;
                    case 4:
                        dcml2_input=Double.parseDouble(editText_dcml2.getText().toString());
                        double bitSonuc=dcml2_input * 8000000;
                        textSonuc_dcml2.setText(Double.toString(bitSonuc));
                        break;



                }


        }









    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}