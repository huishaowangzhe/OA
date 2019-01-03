package com.example.oa10.view;

import android.view.View;

import com.example.oa10.entity.News;


import java.util.List;

public interface MVPView {
    void onSuccess_news(News news);
    void onError();

}
