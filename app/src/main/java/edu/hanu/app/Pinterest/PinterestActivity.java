package edu.hanu.app.Pinterest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.Pinterest.adapters.MyViewPagerAdapter;
import edu.hanu.app.Pinterest.fragments.CraftFragment;
import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.mydesign.R;

public class PinterestActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinterest);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new MyViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new DefaultFragment(), "For you");
        adapter.addFragment(new DefaultFragment(), "Ngẫm");
        adapter.addFragment(new DefaultFragment(), "Xinh");
        adapter.addFragment(new CraftFragment(), "Craft");
        adapter.addFragment(new DefaultFragment(), "Lập trình");
        adapter.addFragment(new DefaultFragment(), "Tips");
        adapter.addFragment(new DefaultFragment(), "Fun");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}