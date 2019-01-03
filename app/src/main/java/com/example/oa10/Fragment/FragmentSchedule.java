package com.example.oa10.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa10.Adapter.ScheduleAdapter;
import com.example.oa10.R;

/**
 * Created by asus on 2018/12/26.
 */

public class FragmentSchedule extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private ScheduleAdapter mScheduleAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentschedule, container, false);

        //隐藏掉整个ActionBar
        android.support.v7.app.ActionBar actionbar=((AppCompatActivity)getActivity()).getSupportActionBar();
        actionbar.hide();
        initViews();
        return mView;
    }
    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) mView.findViewById(R.id.viewPager);
        mScheduleAdapter= new ScheduleAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mScheduleAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_schedule);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);

       /* //设置Tab的图标
        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);*/


    }
}
