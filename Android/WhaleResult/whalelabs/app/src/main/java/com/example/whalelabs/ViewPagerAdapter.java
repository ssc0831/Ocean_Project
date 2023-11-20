package com.example.whalelabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fragmentActivity){super(fragmentActivity);}

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentResult();
            case 2:
                return new FragmentChat();
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
