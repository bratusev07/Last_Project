package com.example.last_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

 class Offline extends AppCompatActivity {
     Button play;
     Button back;
     Button add;
     ListView list;
     ArrayList<String> list_players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        play = (Button) findViewById(R.id.play);
        back = (Button) findViewById(R.id.back);
        add = (Button) findViewById(R.id.add);
        list = (ListView) findViewById(R.id.list);

        MyListener myListener = new MyListener();
        play.setOnClickListener(myListener);
        add.setOnClickListener(myListener);
        back.setOnClickListener(myListener);

        list_players = new ArrayList<String>();
    }

    class MyListener implements View.OnClickListener {
        private int count = 0;
        private EditText editText = (EditText) findViewById(R.id.edit);


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add: {
                    if (editText.getText().toString() != "") {
                        count++;
                        list_players.add(editText.getText().toString());
                        ArrayAdapter<String> playerAdapter = new ArrayAdapter<String>(Offline.this, android.R.layout.simple_list_item_1, list_players);
                        list.setAdapter(playerAdapter);
                        editText.setText("");
                    } else
                        Toast.makeText(getApplicationContext(), "Player not found", Toast.LENGTH_SHORT).show();
                }
                break;

                case R.id.back: {
                    finish();
                }
                break;

                case R.id.play: {
                    if(count > 1){
                    Intent intent = new Intent(Offline.this, Play_Offline.class);
                    intent.putExtra("players", list_players);
                    startActivity(intent);
                    }
                    else Toast.makeText(getApplicationContext(), "Too few players", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }
}
