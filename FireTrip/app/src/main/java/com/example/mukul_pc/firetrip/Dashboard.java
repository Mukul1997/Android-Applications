package com.example.mukul_pc.firetrip;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {

    private Button log,updt;
    private FirebaseAuth mAuth;
    private TextView user,userN,userA;
    String user_id,name;
    int age;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAuth = FirebaseAuth.getInstance();
        dbref = FirebaseDatabase.getInstance().getReference();

        user_id = mAuth.getCurrentUser().getUid();
        user = (TextView)findViewById(R.id.uid);
        user.setText(user_id);
        String names[] = (mAuth.getCurrentUser().getEmail()).split("@");
        name = names[0];
        age = 21;
        userN = (TextView)findViewById(R.id.userName);
        userA = (TextView)findViewById(R.id.userAge);

        log = (Button)findViewById(R.id.logoutBtn);
        updt = (Button)findViewById(R.id.dbAdd);


        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String n = (dataSnapshot.child("Users").child(user_id).child("name").getValue()).toString();
                String a = (dataSnapshot.child("Users").child(user_id).child("age").getValue()).toString();
                userN.setText(n);
                userA.setText(a);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Log.e("Reference : ",dbref.toString());

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(Dashboard.this,Fire1.class));
            }
        });

        updt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToFirebase();
            }
        });
    }

    private void addToFirebase() {
        UserData udata = new UserData(user_id,name,age);
        dbref.child("Users").child(user_id).setValue(udata);
    }
}
