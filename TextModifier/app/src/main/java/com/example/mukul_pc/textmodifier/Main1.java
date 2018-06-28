package com.example.mukul_pc.textmodifier;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main1 extends AppCompatActivity {

    private RadioGroup rg1,rg2;
    private EditText input;
    private TextView disp;
    private Button click;
    String sel1="",sel2="",val="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        rg1 = findViewById(R.id.bg1);
        rg2 = findViewById(R.id.bg2);
        input = findViewById(R.id.inp);
        disp = findViewById(R.id.out);
        click = findViewById(R.id.btn);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                sel1 = ((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                sel2 = ((RadioButton) findViewById(rg2.getCheckedRadioButtonId())).getText().toString();
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 val = input.getText().toString();
                if (val.equals("") || sel1.equals("") || sel2.equals(""))
                    Toast.makeText(Main1.this, "Enter input !", Toast.LENGTH_SHORT).show();
                else {
                    apply();
                   }
                }
        });
    }

    public void apply() {
                if (sel1.equals("Normal"))
                    disp.setTypeface(null, Typeface.NORMAL);
                if (sel1.equals("Bold"))
                    disp.setTypeface(null, Typeface.BOLD);
                if (sel1.equals("Italics"))
                    disp.setTypeface(null, Typeface.ITALIC);

                if (sel2.equals("Left"))
                    disp.setGravity(Gravity.LEFT);
                if (sel2.equals("Centre"))
                    disp.setGravity(Gravity.CENTER);
                if (sel2.equals("Right"))
                    disp.setGravity(Gravity.RIGHT);

                disp.setText(val);
         }
}
