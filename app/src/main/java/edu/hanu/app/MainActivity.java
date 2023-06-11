package edu.hanu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import edu.hanu.app.Facebook.FacebookActivity;
import edu.hanu.app.Instagram.InstagramActivity;
import edu.hanu.app.Pinterest.PinterestActivity;
import edu.hanu.app.test.TestActivity;
import edu.hanu.mydesign.R;
import edu.hanu.app.Tiktok.TiktokActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imv_facebook, imv_instagram, imv_tiktok, imv_pinterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imv_facebook = findViewById(R.id.imv_facebook);
        imv_instagram = findViewById(R.id.imv_instagram);
        imv_tiktok = findViewById(R.id.imv_tiktok);
        imv_pinterest = findViewById(R.id.imv_pinterest);

        imv_facebook.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FacebookActivity.class);
            startActivity(intent);
        });

        imv_instagram.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InstagramActivity.class);
            startActivity(intent);
        });

        imv_tiktok.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TiktokActivity.class);
            startActivity(intent);
        });

        imv_pinterest.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PinterestActivity.class);
            startActivity(intent);
        });
    }
}