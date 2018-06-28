package com.example.mukul_pc.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;

import android.widget.VideoView;

public class Main5Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    String country[] = {"India", "China", "australia", "Portugal", "America", "New Zealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        VideoView  vv = findViewById(R.id.vp);
        lv = findViewById(R.id.list);
        lv.setOnItemClickListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);
        lv.setAdapter(arrayAdapter);
        MediaController mediaController = new MediaController(this);
        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.qwe));
        vv.setMediaController(mediaController);
        mediaController.setAnchorView(vv);
        vv.start();
        //mediaController.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}

//pavan0548@gmail.com