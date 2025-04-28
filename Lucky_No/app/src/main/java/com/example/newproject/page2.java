package com.example.newproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class page2 extends AppCompatActivity {

    TextView nameOutput, numberOutput;

    Button shareBtn;

    String nameOut;

    int randomNumOut;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);

        nameOutput=findViewById(R.id.name);
        numberOutput=findViewById(R.id.numberOutput);
        shareBtn=findViewById(R.id.shareBtn);


        nameOut = getIntent().getStringExtra("Name_Input");
        nameOutput.setText(getFallbackText(nameOut, "No Input from User"));

        //Get Random Number
        randomNumOut = generateRandom();
        numberOutput.setText(""+randomNumOut);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShare();
            }
        });

    }

    private void handleShare() {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, nameOutput + "got Lucky Today");
        intent.putExtra(Intent.EXTRA_TEXT, "His Lucky number is: "+randomNumOut);
        startActivity(Intent.createChooser(intent, "Share Via"));
    }

    public int generateRandom(){
        Random random=new Random();
        int upper_limit = 1000;

        return random.nextInt(upper_limit);
    }

    private String getFallbackText(String input, String fallback) {
        return input != null && !input.isEmpty() ? input : fallback;
    }
}