package com.v2ex.app.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.v2ex.app.fragment.AllArticalFragment;
import com.v2ex.app.fragment.HotArticalFragment;

/**
 * Created by kuxinwei on 2014/9/3.
 */
public class BasePageAdapter extends FragmentPagerAdapter {

    private static final CharSequence[] TITLE = new String[]{"全部", "热门"};

    public BasePageAdapter(FragmentManager fm) {
        super(fm);
    }

    private int count = 2;

    @Override public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllArticalFragment();
            case 1:
                return new HotArticalFragment();
            default:
                throw new IllegalArgumentException("position cannot larger than " + count);
        }
    }

    @Override public int getCount() {
        return count;
    }

    @Override public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}
