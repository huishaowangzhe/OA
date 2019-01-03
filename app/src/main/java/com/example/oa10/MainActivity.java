package com.example.oa10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.oa10.Activity.InformActivity;
import com.example.oa10.Activity.LogActivity;
import com.example.oa10.Activity.PhoneContentActivity;
import com.example.oa10.Fragment.FragementNews;
import com.example.oa10.Fragment.FragmentSchedule;
import com.example.oa10.Fragment.Fragmentabout;
import com.example.oa10.Utils.BottomBar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到抽屉控件
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        //找到导航栏并实现跳转功能
        mNavigationView = (NavigationView)findViewById(R.id.nav_view);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(FragementNews.class,
                        "公司新闻",
                        R.drawable.news,
                        R.drawable.news)
                .addItem(FragmentSchedule.class,
                        "日程安排",
                        R.drawable.schedule,
                        R.drawable.schedule)
                .addItem(Fragmentabout.class,
                        "关于我们",
                        R.drawable.about,
                        R.drawable.about)
                .build();

        //对抽屉实现监听
        mNavigationView.setCheckedItem(R.id.nav_log);//设置默认选中的图标

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //mDrawerLayout.closeDrawers();

                switch(item.getItemId()){
                    case R.id.nav_log://工作日志
                        Log.e("nav_log","jjjjjjj");
                        Intent intent_log = new Intent(MainActivity.this, LogActivity.class);
                        startActivity(intent_log);
                        break;
                    case R.id.nav_inform://通知公告
                        Intent intent_inform = new Intent(MainActivity.this, InformActivity.class);
                        startActivity(intent_inform);
                        break;
                    case R.id.nav_sticky://便利贴
                        Log.e("nav_sticky","jjjjjjj");
                        break;
                    case R.id.nav_telephone://通讯录
                        Log.e("nav_telephone","jjjjjjj");
                        //跳转到通讯录
                        Intent intent_telephone = new Intent(MainActivity.this, PhoneContentActivity.class);
                        startActivity(intent_telephone);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
