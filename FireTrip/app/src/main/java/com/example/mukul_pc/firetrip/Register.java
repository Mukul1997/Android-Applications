package com.example.mukul_pc.firetrip;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText em, ps, cps;
    private Button reg;

    private ProgressDialog pd;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        pd = new ProgressDialog(this);

        em = (EditText) findViewById(R.id.email);
        ps = (EditText) findViewById(R.id.password);
        cps = (EditText) findViewById(R.id.cpassword);

        reg = (Button) findViewById(R.id.regBtn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {

        pd.setMessage("Registering user....");
        pd.show();

        String email = em.getText().toString();
        String password = ps.getText().toString();
        String cpassword = cps.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(cpassword)) {
            em.setError("Error");
            ps.setError("Error");
        }

        if(password.equals(cpassword)) {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(Register.this, "Registration Successful !", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(Register.this, "Registration Failed !", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            ps.setError("passwords do not match");
            cps.setError("passwords do not match");
        }
    }
}
