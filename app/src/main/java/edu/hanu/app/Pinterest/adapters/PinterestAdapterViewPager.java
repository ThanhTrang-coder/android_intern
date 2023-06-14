package edu.hanu.app.Pinterest.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class PinterestAdapterViewPager extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> stringList = new ArrayList<>();

    public PinterestAdapterViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String string) {
        fragmentList.add(fragment);
        stringList.add(string);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
