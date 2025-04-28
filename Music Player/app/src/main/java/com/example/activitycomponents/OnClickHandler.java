package com.example.activitycomponents;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class OnClickHandler {
    private Context context;

    public OnClickHandler(Context context){
        this.context= context;
    }

    public void onButtonClick(View view){
        Toast.makeText(context, "Selected Button Click", Toast.LENGTH_SHORT).show();
    }

    public void playBtnHandle(View view){
        context.startService(new Intent(context, MusicServices.class));
    }

    public void pauseBtnHandle(View view){
        context.stopService(new Intent(context, MusicServices.class));
    }
}

