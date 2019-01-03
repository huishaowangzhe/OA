package com.example.oa10.entity;

import java.util.List;

public class News {


    private List<NewsBean> news;

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class NewsBean {
        /**
         * news_id : 77
         * news_title : bbgbgfbg
         * news_content : gbgfbgfbgfb
         * news_time : 2019.1.1
         */

        private int news_id;
        private String news_title;
        private String news_content;
        private String news_time;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
        }

        public String getNews_time() {
            return news_time;
        }

        public void setNews_time(String news_time) {
            this.news_time = news_time;
        }

        @Override
        public String toString() {
            return "{" +
                    "news_id:" + news_id +
                    ", news_title:'" + news_title + '\'' +
                    ", news_content:'" + news_content + '\'' +
                    ", news_time:'" + news_time + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "{" +
                "news:" + news +
                '}';
    }
}
