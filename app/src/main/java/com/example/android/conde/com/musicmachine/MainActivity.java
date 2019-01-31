package com.example.android.conde.com.musicmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String KEY_SONG = "song";
    private Button mDownloadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDownloadButton = findViewById(R.id.downloadButton);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading...", Toast.LENGTH_SHORT)
                        .show();
                //Send Messages to Handler for processing
                for(String song: PlayList.songs) {
                    Intent intent = new Intent(MainActivity.this,
                            DownloadService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }
            }
        });
    }


}
