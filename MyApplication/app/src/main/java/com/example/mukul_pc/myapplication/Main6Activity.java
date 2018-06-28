package com.example.mukul_pc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    EditText t1;
    TextView t2;
    //Button b;
    int val=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        t1 = findViewById(R.id.tinp);
        t2 = findViewById(R.id.tout);
        //b = findViewById(R.id.bn);
        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                analyzer();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        /*b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                analyzer();
            }
        });*/

    }

    public void analyzer() {
        t1.setHint("Analyzing...");
        val = Integer.parseInt(t1.getText().toString());
        if(val%2==0)
            t2.setText("Issa Even");
        else
            t2.setText("Issa Odd");
    }
}
