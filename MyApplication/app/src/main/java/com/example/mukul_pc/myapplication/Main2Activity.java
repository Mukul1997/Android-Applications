package com.example.mukul_pc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity {

    private ToggleButton tb;
    private ImageButton ibn;
    String s;
    private RadioButton rad1,rad2,rad3;
    private RadioGroup rr;
    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //tb = findViewById(R.id.tbtn);
        ibn = findViewById(R.id.ibtn);
        rr = findViewById(R.id.bgrp1);
        rad1 = findViewById(R.id.r1);
        rad2 = findViewById(R.id.r2);
        rad3 = findViewById(R.id.r3);

        /*tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toaster();
            }
        });*/

        ibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = ((RadioButton)findViewById(rr.getCheckedRadioButtonId()))
                        .getText().toString();
                toaster2();
            }
        });
    }

    /*public void toaster() {
        if (flag == 1) {
            Toast.makeText(this,"Self Destruct Enabled",Toast.LENGTH_SHORT).show();
            flag = 0;
        }
        else {
            Toast.makeText(this,"Self Destruct Disabled",Toast.LENGTH_SHORT).show();
            flag = 1;
        }
    }*/

    public void toaster2() {
        if(s.equals("Classic"))
            func();
        Toast.makeText(this,"Matchmaking..."+s,Toast.LENGTH_SHORT).show();
            s = "";
    }

    public void func() {
        Intent obj = new Intent(Main2Activity.this, Main3Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("blek",s);
        obj.putExtras(bundle);
        startActivity(obj);
    }
}