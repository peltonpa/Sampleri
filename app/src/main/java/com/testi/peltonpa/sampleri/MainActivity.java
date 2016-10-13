package com.testi.peltonpa.sampleri;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp;
    public SoundPool sp;
    public AudioManager am;
    public HashMap<String, Integer> spMap;
    public int sampleId;
    public boolean loaded = false;
    public float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        spMap = new HashMap();
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        initializeSoundpool();

    }

    //Builds AudioAttributes and SoundPool to be utilized for sample playback
    public void initializeSoundpool() {

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        sp = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();

        loadSamplesAndSetVolume();
    }

    public void loadSamplesAndSetVolume() {
        float actualVolume = (float) am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume = actualVolume / maxVolume;



    }

    public void playSnare(View view) {
        try {
            sp.play(sampleId, volume, volume, 1, 0, 1);
        } catch (Exception e) {
            Log.e("playSnare", "MediaPlayer cannot update data source (audio file may not exist)", e);
        }
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
