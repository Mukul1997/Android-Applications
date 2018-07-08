package com.example.mukul_pc.loginandregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2 extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t = findViewById(R.id.uv);
        Bundle bundle = getIntent().getExtras();
        String ss = bundle.getString("blek");
        t.setText(ss);
    }
}
