package com.example.oa10.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oa10.Adapter.NewsAdapter;
import com.example.oa10.Beans.NewsBeans;
import com.example.oa10.R;
import com.example.oa10.Utils.NewsUtils;

import java.util.ArrayList;

/**
 * Created by asus on 2018/12/26.
 */

public class FragementNews extends Fragment implements AdapterView.OnItemClickListener{

    private View view;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentnews, container, false);

        mContext=getActivity();
        //1.获取新闻数据用list封装
        ArrayList<NewsBeans> allNews = NewsUtils.getAllNews(mContext);
        //2.找到控件
        ListView lv_news = (ListView) view.findViewById(R.id.lv_news);
        //3.创建一个adapter设置给listview
        NewsAdapter newsAdapter = new NewsAdapter(mContext, allNews);
        lv_news.setAdapter(newsAdapter);
        //4.设置listview条目的点击事件
        lv_news.setOnItemClickListener(this);


        return view;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//需要获取条目上bean对象中url做跳转
        NewsBeans bean = (NewsBeans) parent.getItemAtPosition(position);

        String url = bean.news_url;

        //跳转浏览器
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}
