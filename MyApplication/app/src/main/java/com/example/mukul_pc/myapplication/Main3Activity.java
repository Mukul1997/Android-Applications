package com.example.mukul_pc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

     TextView tw;
     WebView wv;
     Button bt;
     String sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tw = findViewById(R.id.tw3);
        wv = findViewById(R.id.webber);
        bt = findViewById(R.id.butter);

        Button btt = (Button)findViewById(R.id.btnnext);
        btt.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      func();
                                  }
                              }
        );
        Spinner spinner = (Spinner) findViewById(R.id.spnr1);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.infinity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String ss = bundle.getString("blek");

        tw.setText(ss);
    }

    public void view() {
        wv.loadUrl("https://youtu.be/OddN5aqwgWU");
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        tw.setText("");
        sel = (String) parent.getItemAtPosition(pos);
         tw.setText(sel);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        tw.setText("Nothing selected");
    }

    public void func() {
        Intent obj = new Intent(Main3Activity.this, Main4Activity.class);
        Intent obj2 = new Intent(Main3Activity.this, Main5Activity.class);
        Intent obj3 = new Intent(Main3Activity.this, Main6Activity.class);
        if(sel.equals("Space Stone"))
            startActivity(obj);
        if(sel.equals("Time Stone"))
            startActivity(obj2);
        if(sel.equals("Reality Stone"))
            startActivity(obj3);
    }

}
