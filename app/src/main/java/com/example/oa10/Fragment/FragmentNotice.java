package com.example.oa10.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oa10.Activity.DetailActivity;
import com.example.oa10.Adapter.AnnoAdapter;
import com.example.oa10.Adapter.NoticeAdapter;
import com.example.oa10.Beans.NewsBeans;
import com.example.oa10.R;
import com.example.oa10.Utils.NewsUtils;
import com.example.oa10.entity.Announcement;
import com.example.oa10.entity.News;
import com.example.oa10.entity.Notice;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;
import com.example.oa10.presenter.MyPresenter;
import com.example.oa10.view.MVPView;

import java.util.ArrayList;

/**
 * Created by asus on 2018/12/30.
 */
//通知
public class FragmentNotice extends Fragment implements AdapterView.OnItemClickListener{
    private View view;
    private Context mContext;
    private MyPresenter myPresenter;
    private NoticeAdapter noticeAdapter;
    private ListView lv_news;
    private MVPView mvpView =new MVPView() {
        @Override
        public void onSuccess_news(News news) {
            //Log.e("dsdss",news.toString());
            //newsAdapter = new NewsAdapter(mContext, news.getNews());
            //lv_news.setAdapter(newsAdapter);

        }

        @Override
        public void onSuccess_login(ResultBean resultBean) {

        }

        @Override
        public void onSuccess_announcement(Announcement announcement) {

        }

        @Override
        public void onSuccess_notice(Notice notice) {

            noticeAdapter = new NoticeAdapter(mContext, notice.getNotice());
            lv_news.setAdapter(noticeAdapter);
        }

        @Override
        public void onSuccess_schedule(Schedule schedule) {

        }


        @Override
        public void onError() {

        }
    } ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentnews, container, false);

        mContext=getContext();
        myPresenter=MyPresenter.getInstance(mContext);

        myPresenter.onCreate();
        myPresenter.attachView(mvpView);
        //1.获取新闻数据用list封装
        ArrayList<NewsBeans> allNews = NewsUtils.getAllNews(mContext);
        //2.找到控件
        lv_news = (ListView) view.findViewById(R.id.lv_news);
        //3.创建一个adapter设置给listview

        //4.设置listview条目的点击事件
        lv_news.setOnItemClickListener(this);

        myPresenter.getNotice();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Notice.NoticeBean noticeBean=(Notice.NoticeBean) noticeAdapter.getItem(position);

        Intent intent = new Intent(mContext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("content",noticeBean.getNotice_content());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
