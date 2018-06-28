package com.example.mukul_pc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private EditText tf1,tf2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tf1 = (EditText)findViewById(R.id.uname);
        tf2 = (EditText)findViewById(R.id.upass);

        bt = (Button) findViewById(R.id.btn);
        bt.setOnClickListener(new OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      valid();
                                  }
                              }
        );
    }

    public void valid()
    {
        String name = tf1.getText().toString();
        String pass = tf2.getText().toString();
        if((name.equals("admin")) && (pass.equals("1234")))
            func();
        else
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
    }

    public void func() {
            Intent obj = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(obj);
    }
}
