package edu.hanu.app.Messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import edu.hanu.app.Messenger.adapters.ViewPager2Adapter;
import edu.hanu.mydesign.R;

public class MessengerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int FRAGMENT_CHAT = 0;
    private static final int FRAGMENT_MARKETPLACE = 1;
    private static final int FRAGMENT_WAITING_MESSENGER = 2;
    private static final int FRAGMENT_ARCHIVES = 3;

    private int currentFragment = FRAGMENT_CHAT;
    DrawerLayout drawerLayout;
    ViewPager2 viewPager2;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        viewPager2 = findViewById(R.id.viewPager2);
        bottomNavigationView = findViewById(R.id.bottom_nav_messenger);
        
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        navigationView.setNavigationItemSelectedListener(this);
        viewPager2.setCurrentItem(0);
        navigationView.getMenu().findItem(R.id.nav_chat).setChecked(true);
        
        ViewPager2Adapter adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(adapter);
        viewPager2.setUserInputEnabled(false);
        changeFragmentUsingSwipeViewPage();
        
        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_chat).setChecked(true);
        changeFragmentUsingBottomNav();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_chat) {
            if(currentFragment != FRAGMENT_CHAT) {
                viewPager2.setCurrentItem(0);
                currentFragment = FRAGMENT_CHAT;
            }
        } else if (id == R.id.nav_marketplace) {
            if(currentFragment != FRAGMENT_MARKETPLACE) {
                viewPager2.setCurrentItem(1);
                currentFragment = FRAGMENT_MARKETPLACE;
            }
        } else if (id == R.id.nav_waiting_messenge) {
            if(currentFragment != FRAGMENT_WAITING_MESSENGER) {
                viewPager2.setCurrentItem(2);
                currentFragment = FRAGMENT_WAITING_MESSENGER;
            }
        } else if (id == R.id.nav_archives) {
            if(currentFragment != FRAGMENT_ARCHIVES) {
                viewPager2.setCurrentItem(3);
                currentFragment = FRAGMENT_ARCHIVES;
            }
        }
        setTitleToolBar();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void changeFragmentUsingSwipeViewPage() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case FRAGMENT_CHAT:
                        navigationView.getMenu().findItem(R.id.nav_chat).setChecked(true);
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_chat).setChecked(true);
                        break;
                    case FRAGMENT_MARKETPLACE:
                        navigationView.getMenu().findItem(R.id.nav_marketplace).setChecked(true);
                        break;
                    case FRAGMENT_WAITING_MESSENGER:
                        navigationView.getMenu().findItem(R.id.nav_waiting_messenge).setChecked(true);

                        break;
                    case FRAGMENT_ARCHIVES:
                        navigationView.getMenu().findItem(R.id.nav_archives).setChecked(true);
                        break;
                }
            }
        });
    }

    private void changeFragmentUsingBottomNav() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.bottom_nav_chat) {
                if (currentFragment != FRAGMENT_CHAT) {
                    viewPager2.setCurrentItem(0);
                    currentFragment = FRAGMENT_CHAT;
                    setTitleToolBar();
                }
            }
            return true;
        });
    }

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