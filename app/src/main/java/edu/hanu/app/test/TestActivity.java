package edu.hanu.app.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

import edu.hanu.app.test.adapters.VideoAdapter;
import edu.hanu.app.test.models.VideoModel;
import edu.hanu.mydesign.R;

public class TestActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<VideoModel> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2 = findViewById(R.id.viewPager2);
        videos = new ArrayList<>();

        VideoModel obj1 = new VideoModel("android.resource://" + getPackageName() + "/" + R.raw.video, "Title 1", "This is the basic description of videos which is coming from remote server.");
        videos.add(obj1);

        VideoModel obj2 = new VideoModel("android.resource://" + getPackageName() + "/" + R.raw.video2, "Title 2", "This is the basic description of videos which is coming from remote server.");
        videos.add(obj2);

        VideoModel obj3 = new VideoModel("android.resource://" + getPackageName() + "/" + R.raw.video1, "Title 3", "This is the basic description of videos which is coming from remote server.");
        videos.add(obj3);

        VideoModel obj4 = new VideoModel("android.resource://" + getPackageName() + "/" + R.raw.video3, "Title 4", "This is the basic description of videos which is coming from remote server.");
        videos.add(obj4);

        viewPager2.setAdapter(new VideoAdapter(videos));
    }
}