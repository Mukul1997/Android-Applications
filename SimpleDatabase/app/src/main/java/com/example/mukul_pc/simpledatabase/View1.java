package com.example.mukul_pc.simpledatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class View1 extends AppCompatActivity {

    private Button bt1,bt2;
     private EditText t;
     DatabaseHelper md;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        t = findViewById(R.id.inp);
        bt1 = findViewById(R.id.ins);
        bt2 = findViewById(R.id.vw);
        md = new DatabaseHelper(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = t.getText().toString();
                if(t.length() != 0) {
                    AddData(newEntry);
                    t.setText("");
                }
                else {
                    toaster("You must put something in the text field");
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(View1.this,View2.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String newEntry) {
        boolean insertData = md.addData(newEntry);
        if(insertData)
            toaster("Data Successfully Inserted !");
        else
            toaster("Something went Wrong !");
    }

    private void toaster(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
