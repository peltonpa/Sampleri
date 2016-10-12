package com.testi.peltonpa.sampleri;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mp = MediaPlayer.create(this, R.raw.snare);

    }

    public void playSnare(View view) {
        try {
            this.mp.release();
            this.mp = MediaPlayer.create(this, R.raw.snare);
        } catch (Exception e) {
            Log.e("playSnare", "MediaPlayer cannot update data source (audio file may not exist)", e);
        }
        mp.start();
    }


    public void playKick(View view) {
        try {
            this.mp.release();
            this.mp = MediaPlayer.create(this, R.raw.kick);
        } catch (Exception e) {
            Log.e("playKick", "MediaPlayer cannot update data source (audio file may not exist", e);
        }
        mp.start();
    }

    public void playHat(View view) {
        try {
            this.mp.release();
            this.mp = MediaPlayer.create(this, R.raw.hattu);
        } catch (Exception e) {
            Log.e("playKick", "MediaPlayer cannot update data source (audio file may not exist", e);
        }
        mp.start();
    }

}
