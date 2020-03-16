package com.example.chichi.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.chichi.ui.fragment.MessageFragment;
import com.example.chichi.ui.fragment.InfoFragment;
import com.example.chichi.ui.fragment.PictureFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> items = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);//
        items.add(new MessageFragment());
        items.add(new PictureFragment());
        items.add(new InfoFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}