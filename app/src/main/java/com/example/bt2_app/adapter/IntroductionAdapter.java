package com.example.bt2_app.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class IntroductionAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayListFragment = new ArrayList<>();
    private ArrayList<String> arrayListTitle = new ArrayList<>();

    public IntroductionAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayListFragment.get(position);
    }

    @Override
    public int getCount() {
        return arrayListFragment.size();
    }

    public void addData(Fragment fm, String title) {
        arrayListFragment.add(fm);
        arrayListTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayListTitle.get(position);
    }
}
