package edu.hanu.app.Tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.Facebook.adapters.HomePagerAdapter;
import edu.hanu.app.Facebook.fragments.HomeFragment;
import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.mydesign.R;

public class TiktokActivity extends AppCompatActivity {
    HomePagerAdapter homePagerAdapter;
    ViewPager postList;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);

//        postList = findViewById(R.id.post_list1);
//        tabLayout = findViewById(R.id.tabLayoutFb);
//
//        setUpPagerAdapter();
//
//        setUpTabLayout();

    }

//    private void setUpPagerAdapter() {
//        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
//        homePagerAdapter.addFragment(new HomeFragment(), "");
//        homePagerAdapter.addFragment(new DefaultFragment(), "");
//        homePagerAdapter.addFragment(new DefaultFragment(), "");
//        homePagerAdapter.addFragment(new DefaultFragment(), "");
//        homePagerAdapter.addFragment(new DefaultFragment(), "");
//        homePagerAdapter.addFragment(new DefaultFragment(), "");
//
//        postList.setAdapter(homePagerAdapter);
//    }
//    private void setUpTabLayout() {
//        tabLayout.setupWithViewPager(postList);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_watch_video);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_heart);
//        tabLayout.getTabAt(3).setIcon(R.drawable.ic_game);
//        tabLayout.getTabAt(4).setIcon(R.drawable.ic_notification);
//        tabLayout.getTabAt(5).setIcon(R.drawable.menu_hamburger);
//
//        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
//        tabLayout.getTabAt(5).getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                tab.getIcon().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }


}