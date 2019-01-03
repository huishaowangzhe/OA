package com.example.oa10.manager;

import android.content.Context;
import android.util.Log;


import com.example.oa10.Utils.RetrofitHelper;
import com.example.oa10.Utils.RetrofitService;
import com.example.oa10.entity.News;


import java.util.List;

import rx.Observable;


/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<News> getAllNews(){
        Log.e("dsdss","1");
        return  mRetrofitService.getAllNews();
    }



}
