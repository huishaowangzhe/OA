package com.example.oa10.entity;

import java.util.List;

public class Announcement {

    private List<AnnouncementBean> announcement;

    public List<AnnouncementBean> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<AnnouncementBean> announcement) {
        this.announcement = announcement;
    }

    public static class AnnouncementBean {
        /**
         * anno_id : 88
         * anno_title : grfvdfv
         * anno_content : sdscdscdcdcdscdc
         * anno_time : 1.2
         */

        private int anno_id;
        private String anno_title;
        private String anno_content;
        private String anno_time;

        public int getAnno_id() {
            return anno_id;
        }

        public void setAnno_id(int anno_id) {
            this.anno_id = anno_id;
        }

        public String getAnno_title() {
            return anno_title;
        }

        public void setAnno_title(String anno_title) {
            this.anno_title = anno_title;
        }

        public String getAnno_content() {
            return anno_content;
        }

        public void setAnno_content(String anno_content) {
            this.anno_content = anno_content;
        }

        public String getAnno_time() {
            return anno_time;
        }

        public void setAnno_time(String anno_time) {
            this.anno_time = anno_time;
        }
    }
}
