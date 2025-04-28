package com.example.contactlistview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactlistview.Adapter.MyCustomAdapter;
import com.example.contactlistview.ModelClass.contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    ArrayList<contact> contactArrayList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);


        contactArrayList= new ArrayList<>();

        contactArrayList.add(new contact( R.drawable.img1, "Harshal", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img2,"Pankaj", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img3, "Piyush", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img4,"Harshad", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img4, "Chaitanya", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img4,"Yogeshwari", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img4,"Ram", "7498830046"));
        contactArrayList.add(new contact(R.drawable.img4,"Chintu", "7498830046"));

        MyCustomAdapter adapter = new MyCustomAdapter(this, contactArrayList);
        listview.setAdapter(adapter);
    }



}