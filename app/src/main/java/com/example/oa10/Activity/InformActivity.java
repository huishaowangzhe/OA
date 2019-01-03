package com.example.oa10.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.oa10.Adapter.InformAdapter;
import com.example.oa10.R;

public class InformActivity extends AppCompatActivity {
    private TabLayout inform_mTabLayout;
    private ViewPager inform_ViewPager;

    private InformAdapter mInformAdapter;

    private TabLayout.Tab inform_one;
    private TabLayout.Tab inform_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);


        //初始化视图
        inform_initViews();

    }
    private void inform_initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        inform_ViewPager= (ViewPager) findViewById(R.id.inform_viewPager);
        mInformAdapter = new InformAdapter(getSupportFragmentManager());
        inform_ViewPager.setAdapter(mInformAdapter);

        //将TabLayout与ViewPager绑定在一起
        inform_mTabLayout = (TabLayout) findViewById(R.id.tab_inform);
        inform_mTabLayout.setupWithViewPager(inform_ViewPager);

        //指定Tab的位置
        inform_one = inform_mTabLayout.getTabAt(0);
        inform_two = inform_mTabLayout.getTabAt(1);

       /* //设置Tab的图标
        one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);
        four.setIcon(R.mipmap.ic_launcher);*/


    }
}
