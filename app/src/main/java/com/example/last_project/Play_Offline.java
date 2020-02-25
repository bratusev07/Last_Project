package com.example.last_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Play_Offline extends AppCompatActivity {

    private ArrayList<String> list_players;
    private Button getter;
    private Button clear;
    private Button back;
    private TextView taker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__offline);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        list_players = (ArrayList<String>) getIntent().getSerializableExtra("players");
        getter = (Button) findViewById(R.id.getter);
        clear = (Button) findViewById(R.id.clear);
        back = (Button) findViewById(R.id.back);

        MyListener myListener = new MyListener();

        getter.setOnClickListener(myListener);
        clear.setOnClickListener(myListener);
        back.setOnClickListener(myListener);
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            taker = (TextView) findViewById(R.id.taker);

            switch (v.getId()) {
                case R.id.back: {
                    finish();
                }
                break;
                case R.id.getter: {
                    if (list_players.size() > 0) {
                        int random = (int) (Math.random() * list_players.size());
                        taker.setText(list_players.get(random));
                        list_players.remove(random);
                    } else Toast.makeText(getApplicationContext(), "The list of players is empty", Toast.LENGTH_SHORT).show();
                }
                break;
                case R.id.clear: {
                    taker.setText("");
                }
                break;
            }
        }
    }
}
