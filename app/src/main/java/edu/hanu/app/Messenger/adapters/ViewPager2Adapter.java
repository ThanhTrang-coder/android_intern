package edu.hanu.app.Messenger.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.hanu.app.Messenger.fragments.ChatFragment;
import edu.hanu.app.Pinterest.fragments.DefaultFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new ChatFragment();
            case 1: return new DefaultFragment();
            case 2: return new DefaultFragment();
            case 3: return new DefaultFragment();
            default: return new DefaultFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
