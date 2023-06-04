package edu.hanu.app.Pinterest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.Pinterest.adapters.PinterestAdapterViewPager;
import edu.hanu.app.Pinterest.fragments.CraftFragment;
import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.mydesign.R;

public class PinterestActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PinterestAdapterViewPager pinterestAdapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinterest);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);

        pinterestAdapterViewPager = new PinterestAdapterViewPager(getSupportFragmentManager());

        pinterestAdapterViewPager.addFragment(new DefaultFragment(), "For you");
        pinterestAdapterViewPager.addFragment(new DefaultFragment(), "Ngẫm");
        pinterestAdapterViewPager.addFragment(new DefaultFragment(), "Xinh");
        pinterestAdapterViewPager.addFragment(new CraftFragment(), "Craft");
        pinterestAdapterViewPager.addFragment(new DefaultFragment(), "Lập trình");
        pinterestAdapterViewPager.addFragment(new DefaultFragment(), "Tips");
        pinterestAdapterViewPager.addFragment(new DefaultFragment(), "Fun");

        viewPager.setAdapter(pinterestAdapterViewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
}