package com.testi.peltonpa.sampleri;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        mp.start();
    }


    public void playKick(View view) {
        mp.start();
    }

    public void playHat(View view) {
        mp.start();
    }
    
}
