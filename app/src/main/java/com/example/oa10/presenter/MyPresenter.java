package com.example.oa10.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.oa10.entity.News;
import com.example.oa10.manager.DataManager;
import com.example.oa10.view.MVPView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by wl624 on 2017/10/17.
 */

public class MyPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private MVPView newView;
    //private ArticleView articleView;
    private News myNews;
    //private Article article;
    //private Theme theme;


    public MyPresenter (Context mContext){
        this.mContext = mContext;
    }
    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(MVPView view) {
        newView=(MVPView) view;
        //

    }
    public void getAllNews(){


        /**
        String weatherUrl="http://219.231.12.16:8080/news";
        //System.out.println(weatherUrl);
        HttpUtil.sendHttpRequest(weatherUrl, new HttpCallbackListener() {
            public void onFinish(String response) {

                Log.e("wws",response);
                //dealResponse(response);
                //Message message1=new Message();
                //message1.what=SHOW_RESPONSE;
                //handler.sendMessage(message1);
            }
            public void onError(Exception e) {
                Log.e("error","访问失败");
            }
        });

         **/

        mCompositeSubscription.add(manager.getAllNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<News>() {
                    @Override
                    public void onCompleted() {
                        if (myNews != null){
                            //newView.stopRefreshing();

                            newView.onSuccess_news(myNews);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }
                    @Override
                    public void onNext(News news1) {

                        myNews = news1;
                    }

                })
        );



    }

}
