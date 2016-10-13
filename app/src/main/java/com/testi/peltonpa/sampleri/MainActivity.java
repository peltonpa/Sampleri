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

    private SoundPool sp;
    private AudioManager am;
    private HashMap<String, Integer> soundMap;
    private float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        soundMap = new HashMap();
        am = (AudioManager) getSystemService(AUDIO_SERVICE);

        initializeSoundpool();

        loadSamplesAndSetVolume();
    }

    //Builds AudioAttributes and SoundPool to be utilized for sample playback
    private void initializeSoundpool() {

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build();

        sp = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();
    }

    //Sets volume attribute to (current cell phone music volume) / (cell phone max volume)
    // and loads samples onto SoundPool and maps their id's to soundMap
    private void loadSamplesAndSetVolume() {
        float actualVolume = (float) am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume = actualVolume / maxVolume;

        soundMap.put("snare", Integer.valueOf(sp.load(this, R.raw.snare, 1)));
        soundMap.put("kick", Integer.valueOf(sp.load(this, R.raw.kick, 1)));
        soundMap.put("hat", Integer.valueOf(sp.load(this, R.raw.hattu, 1)));
    }

    public void playSnare(View view) {
        try {
            sp.play(soundMap.get("snare"), volume, volume, 1, 0, 1);
        } catch (Exception e) {
            Log.e("playSnare", "MediaPlayer cannot update data source (audio file may not exist)", e);
        }
    }


    public void playKick(View view) {
        try {
            sp.play(soundMap.get("kick"), volume, volume, 1, 0 ,1);
        } catch (Exception e) {
            Log.e("playKick", "MediaPlayer cannot update data source (audio file may not exist", e);
        }
    }

    public void playHat(View view) {
        try {
            sp.play(soundMap.get("hat"), volume, volume, 1, 0, 1);
        } catch (Exception e) {
            Log.e("playKick", "MediaPlayer cannot update data source (audio file may not exist", e);
        }
    }

}
