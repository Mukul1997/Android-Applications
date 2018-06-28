package com.example.mukul_pc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,bclr,tot,ad,sb;
    private TextView tt;
    int n1,n2,p = 0,s = 0;
    int resAdd,resSub;
    String val = "";
    int addVal = 0;
    int subVal = 0;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tt = findViewById(R.id.screen);

        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.four);
        b5 = findViewById(R.id.five);
        b6 = findViewById(R.id.six);
        b7 = findViewById(R.id.seven);
        b8 = findViewById(R.id.eight);
        b9 = findViewById(R.id.nine);
        b0 = findViewById(R.id.zero);
        bclr = findViewById(R.id.clr);
        tot = findViewById(R.id.equal);
        ad = findViewById(R.id.add);
        sb = findViewById(R.id.sub);

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b1.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b2.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b3.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b4.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b5.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b0.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b0.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b6.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b7.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b8.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        b9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        val += b9.getText().toString();
                        tt.setText(val);
                    }
                }
        );
        bclr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //if(cnt==5)
                         //   show();
                        val = "";
                        addVal = 0;
                        subVal = 0;
                        tt.setText("");
                        tt.setHint("0");
                        p = 0;
                        s = 0;
                        cnt++;
                    }
                }
        );
        ad.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (tt.getText().toString().equals(""))
                            Toast.makeText(Main4Activity.this, "No Values", Toast.LENGTH_SHORT).show();
                        else {
                            n1 = Integer.parseInt(val);
                            addVal += n1;
                            p = 1;
                            s = 0;
                            val = "";
                            tt.setText("");
                            tt.setHint("+");
                        }
                    }
                }
        );
        sb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (tt.getText().toString().equals(""))
                            Toast.makeText(Main4Activity.this, "No Values", Toast.LENGTH_SHORT).show();
                        else {
                            n1 = Integer.parseInt(val);
                            if(subVal == 0) {
                                subVal = n1;
                                s = 1;
                                p = 0;
                                val = "";
                                tt.setText("");
                                tt.setHint("-");
                            }
                            else {
                                subVal -= n1;
                                s = 1;
                                p = 0;
                                val = "";
                                tt.setText("");
                                tt.setHint("-");
                            }
                        }
                    }
                }
        );
        tot.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (tt.getText().toString().equals(""))
                            Toast.makeText(Main4Activity.this, "No Values", Toast.LENGTH_SHORT).show();
                        else {
                            n2 = Integer.parseInt(tt.getText().toString());
                            tt.setText("");
                            res();
                            val = tt.getText().toString();
                        }
                    }
                }
        );
    }
    public void res() {
        if(p == 1) {
            int sum = addVal+n2;
            String r = Integer.toString(sum);
            tt.setText(r);
            addVal = 0;
            n1 = 0;
            n2 = 0;
        }
         else if(s == 1) {
            int diff = subVal-n2;
            String r = Integer.toString(diff);
            tt.setText(r);
            subVal = 0;
            n1 = 0;
            n2 = 0;
        }
    }

    public void show() {
        Intent obj = new Intent(Main4Activity.this, Main5Activity.class);
            startActivity(obj);
            cnt = 0;
    }
}
