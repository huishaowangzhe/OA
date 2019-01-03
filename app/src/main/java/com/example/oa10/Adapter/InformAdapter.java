package com.example.oa10.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.oa10.Fragment.FragmentAnnouncement;
import com.example.oa10.Fragment.FragmentNotice;

/**
 * Created by asus on 2018/12/30.
 */

public class InformAdapter extends FragmentPagerAdapter {
    private String[] inform_Titles = new String[]{"通知","公告"};

    public InformAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new FragmentNotice();
        }
        return new FragmentAnnouncement();
    }

    @Override
    public int getCount() {
        return inform_Titles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return inform_Titles[position];
    }
}
