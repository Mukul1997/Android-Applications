package com.example.mukul_pc.simpledatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class View2 extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    private ListView lst;
    DatabaseHelper md;
    private Context activity;
    private Button bt;
    Cursor cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        lst = (ListView)findViewById(R.id.lv);
        bt = (Button)findViewById(R.id.clr);
        md = new DatabaseHelper(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertD();
            }
        });

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                //alertD();
            }
        });

        populateListView();
    }

    public void alertD() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(View2.this);
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(View2.this, "Edit", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(View2.this, "Delete ", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create();
        builder.show();
    }

    public void populateListView() {
        Log.d(TAG,"populateListView: Displaying Data in the ListView");

        Cursor data = md.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(0)+" . "+data.getString(1));
        }
        ListAdapter lad = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        lst.setAdapter(lad);
    }

    public Context getActivity() {
        return activity;
    }
}
