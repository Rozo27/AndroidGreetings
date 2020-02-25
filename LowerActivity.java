package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class LowerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower);

        VideoView video=findViewById(R.id.videoView);
        String videoPath="android.resource://com.example.myapplication/"+R.raw.video1;
        Uri uri= Uri.parse(videoPath);
        video.setVideoURI(uri);
        //Videoclipul porneste iemdiat dupa lansarea activity-ului: video.start();
        MediaController mediaController=new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
    }
}
