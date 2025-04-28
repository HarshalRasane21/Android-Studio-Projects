package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editName=findViewById(R.id.fName);
        submitBtn=findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(v -> handleSubmit());

    }
    private  void handleSubmit(){
        String nameinput = editName.getText().toString().trim();

        Intent intent = new Intent(MainActivity.this, page2.class );
        intent.putExtra("Name_Input", nameinput);
        startActivity(intent);
    }
}