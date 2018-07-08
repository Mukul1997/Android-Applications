package com.example.mukul_pc.loginandregistration;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class Main2 extends AppCompatActivity {

    private TextView t;
    private Session session;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session = new Session(getApplicationContext());
        t = findViewById(R.id.uv);
        //Bundle bundle = getIntent().getExtras();
        //String ss = bundle.getString("blek");
        String ss = session.getUseName();
        t.setText(ss);

        alertDialog = new AlertDialog.Builder(Main2.this).create();
        alertDialog.setTitle("Log out ?");
        alertDialog.setMessage("Click OK to logout");
        alertDialog.setIcon(R.drawable.danger);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                session.destroy(getApplicationContext());
                finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            //Toast.makeText(this, "Logging out....", Toast.LENGTH_SHORT).show();
            alertDialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
