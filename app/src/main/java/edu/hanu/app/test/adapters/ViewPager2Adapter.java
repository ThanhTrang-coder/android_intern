package edu.hanu.app.test.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.hanu.app.Pinterest.fragments.DefaultFragment;
import edu.hanu.app.test.fragments.TestFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new TestFragment();
            case 1: return new DefaultFragment();
            default: return new DefaultFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
