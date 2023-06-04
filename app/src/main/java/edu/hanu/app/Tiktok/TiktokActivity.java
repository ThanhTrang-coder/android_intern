package edu.hanu.app.Tiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import edu.hanu.app.Facebook.adapters.FbAdapterViewPager;
import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.app.Tiktok.adapters.TikTokAdapterViewPager;
import edu.hanu.app.Tiktok.fragments.SearchFragment;
import edu.hanu.mydesign.R;

public class TiktokActivity extends AppCompatActivity {
    ViewPager2 tiktok_view_pager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktok);

        bottomNavigationView = findViewById(R.id.tiktok_bottom_nav);
        tiktok_view_pager = findViewById(R.id.tiktok_view_pager);

        setUpViewPagerWithBottomNav();
    }

    private void setUpViewPagerWithBottomNav() {
        fragmentArrayList.add(new DefaultFragment());
        fragmentArrayList.add(new SearchFragment());
        fragmentArrayList.add(new DefaultFragment());
        fragmentArrayList.add(new DefaultFragment());
        fragmentArrayList.add(new DefaultFragment());

        TikTokAdapterViewPager tikTokAdapterViewPager = new TikTokAdapterViewPager(this, fragmentArrayList);
        tiktok_view_pager.setAdapter(tikTokAdapterViewPager);
        tiktok_view_pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_menu_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_menu_search);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_menu_add);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_menu_video);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_menu_account);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_nav_menu_home:
                    tiktok_view_pager.setCurrentItem(0);
                case R.id.bottom_nav_menu_search:
                    tiktok_view_pager.setCurrentItem(1);
                    break;
                case R.id.bottom_nav_menu_add:
                    tiktok_view_pager.setCurrentItem(2);
                    break;
                case R.id.bottom_nav_menu_video:
                    tiktok_view_pager.setCurrentItem(3);
                    break;
                case R.id.bottom_nav_menu_account:
                    tiktok_view_pager.setCurrentItem(4);
                    break;
            }
            return true;
        });
    }

}