package com.example.oa10.entity;

import java.util.List;

public class Notice {

    private List<NoticeBean> notice;

    public List<NoticeBean> getNotice() {
        return notice;
    }

    public void setNotice(List<NoticeBean> notice) {
        this.notice = notice;
    }

    public static class NoticeBean {
        /**
         * notice_id : 88
         * notice_title : fbgbg
         * notice_content : gbfbgfbgfbgbgfb
         * notice_time : 1.4
         */

        private int notice_id;
        private String notice_title;
        private String notice_content;
        private String notice_time;

        public int getNotice_id() {
            return notice_id;
        }

        public void setNotice_id(int notice_id) {
            this.notice_id = notice_id;
        }

        public String getNotice_title() {
            return notice_title;
        }

        public void setNotice_title(String notice_title) {
            this.notice_title = notice_title;
        }

        public String getNotice_content() {
            return notice_content;
        }

        public void setNotice_content(String notice_content) {
            this.notice_content = notice_content;
        }

        public String getNotice_time() {
            return notice_time;
        }

        public void setNotice_time(String notice_time) {
            this.notice_time = notice_time;
        }
    }
}
