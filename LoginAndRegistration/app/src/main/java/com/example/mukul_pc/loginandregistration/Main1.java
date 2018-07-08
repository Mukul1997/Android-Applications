package com.example.mukul_pc.loginandregistration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Main1 extends AppCompatActivity {

    private Session session;
    private EditText username;
    private EditText password;
    private ImageButton submit;
    String u="";
    String p="";
    int pa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        username = (EditText)findViewById(R.id.usr);
        password = (EditText)findViewById(R.id.pswd);
        submit = (ImageButton)findViewById(R.id.login);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = username.getText().toString();
                p = password.getText().toString();

                if(u.equals("") || p.equals("")) {
                    username.setError("Enter username");
                    password.setError("Enter password");
                }
                else {
                    pa = Integer.parseInt(p);
                    login();
                }
            }
        });
    }

        @Override
        public void onResume() {
            super.onResume();
            username.setText("");
            password.setText("");
        }

    public void login() {
        String url = "http://192.168.2.9/androidApp/android1.php";

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")) {
                            session = new Session(getApplicationContext());
                            session.setUseName(u);
                            Intent obj = new Intent(Main1.this, Main2.class);
                            //Bundle bundle = new Bundle();
                            //bundle.putString("blek", u);
                            //obj.putExtras(bundle);
                            startActivity(obj);
                        }
                        else
                            Toast.makeText(Main1.this, "Wrong username or password !", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("username",u);
                params.put("password",p);
                return params;
            }

        };
        Volley.newRequestQueue(this).add(request);
    }
}
