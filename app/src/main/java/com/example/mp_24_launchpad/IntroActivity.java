package com.example.mp_24_launchpad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        VideoView videoView = findViewById(R.id.intro_video_view);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro_video_1920);
        videoView.setVideoURI(videoUri);

        videoView.start();

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.setOnErrorListener((mp, what, extra) -> {
            Toast.makeText(getApplicationContext(), "IntroError", Toast.LENGTH_SHORT).show();
            return false;
        });
    }
}