package com.hammam.savedio;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adapt_Pager extends FragmentPagerAdapter {


    ArrayList<Fragment> FragmentList = new ArrayList<Fragment>();

    public Adapt_Pager(FragmentManager fm, ArrayList<Fragment> FragmentList) {
        super(fm);
        this.FragmentList=FragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return FragmentList.get(i);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return super.isViewFromObject(view, object);
    }
}
