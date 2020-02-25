package com.example.last_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

     Button continue_play;
     Button online_play;
     Button offline_play;

     MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();


        continue_play = (Button) findViewById(R.id.continue_game);
        online_play = (Button) findViewById(R.id.online);
        offline_play = (Button) findViewById(R.id.offline);

        MyListener0 myListener0 = new MyListener0();

        continue_play.setOnClickListener(myListener0);
        online_play.setOnClickListener(myListener0);
        offline_play.setOnClickListener(myListener0);
    }

    class MyListener0 implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.online: {break;
                }


                case R.id.offline: {
                    Intent intent = new Intent(MainActivity.this, Offline.class);
                    startActivity(intent);break;
                }


                case R.id.continue_game: { break;}


            }
        }
    }

    private void releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        mp.setLooping(true);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }
}
