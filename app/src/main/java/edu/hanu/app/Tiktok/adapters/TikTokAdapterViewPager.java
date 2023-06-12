package edu.hanu.app.Tiktok.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.app.Tiktok.fragments.HomeFragment;

public class TikTokAdapterViewPager extends FragmentStatePagerAdapter {
    ArrayList<Fragment> arrayList;

    public TikTokAdapterViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new DefaultFragment();
            case 2: return new DefaultFragment();
            case 3: return new DefaultFragment();
            case 4: return new DefaultFragment();
            default: return new DefaultFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
