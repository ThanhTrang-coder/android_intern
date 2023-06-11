package edu.hanu.app.Tiktok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.hanu.app.Tiktok.adapters.TikTokAdapterViewPager;
import edu.hanu.mydesign.R;

public class TiktokActivity extends AppCompatActivity {
    ViewPager tiktok_view_pager;
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

        TikTokAdapterViewPager tikTokAdapterViewPager = new TikTokAdapterViewPager(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tiktok_view_pager.setAdapter(tikTokAdapterViewPager);

        tiktok_view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_search).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_add).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_video).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_menu_account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_menu_home:
                        tiktok_view_pager.setCurrentItem(0);
                        break;
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
                return false;
            }
        });
    }
}