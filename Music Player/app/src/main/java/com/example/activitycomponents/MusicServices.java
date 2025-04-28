package com.example.activitycomponents;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicServices extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer= MediaPlayer.create(this, R.raw.squid);
        mediaPlayer.start();

        return  START_STICKY;
    }

    @Override
    public void onDestroy(){
        mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
