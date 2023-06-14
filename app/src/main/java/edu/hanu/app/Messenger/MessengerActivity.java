package edu.hanu.app.Messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import edu.hanu.app.Messenger.adapters.ViewPager2Adapter;
import edu.hanu.mydesign.R;

public class MessengerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int FRAGMENT_CHAT = 0;
    private static final int FRAGMENT_MARKETPLACE = 1;
    private static final int FRAGMENT_WAITING_MESSENGER = 2;
    private static final int FRAGMENT_ARCHIVES = 3;

    private int currentFragment = FRAGMENT_CHAT;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;
    private NavigationView navigationView;
    private ViewPager2Adapter viewPager2Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_chat).setChecked(true);

        bottomNavigationView = findViewById(R.id.bottom_nav_messenger);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.bottom_nav_chat) {
                    viewPager2.setCurrentItem(0);
                    setTitleToolBar();
                    bottomNavigationView.getMenu().findItem(R.id.bottom_nav_chat).setChecked(true);
                } else if(id == R.id.bottom_nav_video_call) {

                    bottomNavigationView.getMenu().findItem(R.id.bottom_nav_video_call).setChecked(true);
                } else if (id == R.id.bottom_nav_phonebook) {

                    bottomNavigationView.getMenu().findItem(R.id.bottom_nav_phonebook).setChecked(true);
                } else if (id == R.id.bottom_nav_newsfeed) {

                    bottomNavigationView.getMenu().findItem(R.id.bottom_nav_newsfeed).setChecked(true);
                }
                return true;
            }
        });

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case FRAGMENT_CHAT:
                        currentFragment = FRAGMENT_CHAT;
                        navigationView.getMenu().findItem(R.id.nav_chat).setChecked(true);
                        break;
                    case FRAGMENT_MARKETPLACE:
                        currentFragment = FRAGMENT_MARKETPLACE;
                        navigationView.getMenu().findItem(R.id.nav_marketplace).setChecked(true);
                        break;
                    case FRAGMENT_WAITING_MESSENGER:
                        currentFragment = FRAGMENT_WAITING_MESSENGER;
                        navigationView.getMenu().findItem(R.id.nav_messenger).setChecked(true);
                        break;
                    case FRAGMENT_ARCHIVES:
                        currentFragment = FRAGMENT_ARCHIVES;
                        navigationView.getMenu().findItem(R.id.nav_archives).setChecked(true);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_chat:
                viewPager2.setCurrentItem(0);
                break;
            case R.id.nav_marketplace:
                viewPager2.setCurrentItem(1);
                break;
            case R.id.nav_messenger:
                viewPager2.setCurrentItem(2);
                break;
            case R.id.nav_archives:
                viewPager2.setCurrentItem(3);
                break;
        }
        setTitleToolBar();
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

//    @Override
//    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    private void setTitleToolBar() {
        String title = "";
        switch (currentFragment) {
            case FRAGMENT_CHAT:
                title = getString(R.string.nav_chat);
                break;
            case FRAGMENT_MARKETPLACE:
                title = getString(R.string.nav_marketplace);
                break;
            case FRAGMENT_WAITING_MESSENGER:
                title = getString(R.string.nav_waiting_messenger);
                break;
            case FRAGMENT_ARCHIVES:
                title = getString(R.string.nav_archives);
                break;
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}