package edu.hanu.app.Tiktok.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class TikTokAdapterViewPager extends FragmentStateAdapter {
    ArrayList<Fragment> arrayList;

    public TikTokAdapterViewPager(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        super(fragmentActivity);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
