package edu.hanu.app.Instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import edu.hanu.app.Instagram.adapters.InsAdapterViewPager;
import edu.hanu.app.Instagram.fragments.HomeFragment;
import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.mydesign.R;

public class InstagramActivity extends AppCompatActivity {
    ViewPager2 instagram_view_pager;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        bottomNavigationView = findViewById(R.id.ins_bottom_nav);
        instagram_view_pager = findViewById(R.id.instagram_view_pager);

        setUpViewPagerWithBottomNav();

    }

    private void setUpViewPagerWithBottomNav() {
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new DefaultFragment());
        fragmentArrayList.add(new DefaultFragment());
        fragmentArrayList.add(new DefaultFragment());
        fragmentArrayList.add(new DefaultFragment());

        InsAdapterViewPager instagramAdapterViewPager = new InsAdapterViewPager(this, fragmentArrayList);
        instagram_view_pager.setAdapter(instagramAdapterViewPager);
        instagram_view_pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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
                    instagram_view_pager.setCurrentItem(0);
                    break;
                case R.id.bottom_nav_menu_search:
                    instagram_view_pager.setCurrentItem(1);
                    break;
                case R.id.bottom_nav_menu_add:
                    instagram_view_pager.setCurrentItem(2);
                    break;
                case R.id.bottom_nav_menu_video:
                    instagram_view_pager.setCurrentItem(3);
                    break;
                case R.id.bottom_nav_menu_account:
                    instagram_view_pager.setCurrentItem(4);
                    break;

            }
            return true;
        });
    }
}