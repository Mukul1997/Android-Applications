package com.example.mukul_pc.firetrip;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity {

    private Button log,updt,imgupl;
    private FirebaseAuth mAuth;
    private TextView user,userN,userA;
    private ImageView prof;
    private ProgressDialog p;
    String user_id,name;
    int age;
    DatabaseReference dbref;
    StorageReference stref;
    private static final int REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        p = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();

        dbref = FirebaseDatabase.getInstance().getReference();
        stref = FirebaseStorage.getInstance().getReference();

        //user = (TextView)findViewById(R.id.uid);
        //user.setText(user_id);
        String names[] = (mAuth.getCurrentUser().getEmail()).split("@");
        name = names[0];
        age = 21;
        userN = (TextView)findViewById(R.id.userName);
        userA = (TextView)findViewById(R.id.userAge);

        log = (Button)findViewById(R.id.logoutBtn);
        updt = (Button)findViewById(R.id.dbAdd);
        imgupl = (Button)findViewById(R.id.imgUpl);
        prof = (ImageView)findViewById(R.id.profile);


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

        imgupl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE && resultCode == RESULT_OK) {
            p.setMessage("Uploading...");
            p.show();
            Uri uri = data.getData();
            StorageReference filepath = stref.child("Profile").child(user_id);

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    p.setMessage("Done");
                    p.dismiss();
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        stref.child("Profile").child(user_id).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(prof);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Picasso.get().load("https://www.google.co.in/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwju-oOMrZzcAhWKvY8KHa2hAe8QjRx6BAgBEAU&url=https%3A%2F%2Fwww.istockphoto.com%2Fillustrations%2Ffile-not-found&psig=AOvVaw3DW57DyqDWkrSOJD91-wMF&ust=1531580759868584").into(prof);
            }
        });

    }

    private void addToFirebase() {
        UserData udata = new UserData(user_id,name,age);
        dbref.child("Users").child(user_id).setValue(udata);
    }
}
