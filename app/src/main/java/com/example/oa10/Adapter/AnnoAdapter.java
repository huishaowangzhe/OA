package com.example.oa10.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oa10.R;
import com.example.oa10.entity.Announcement;
import com.example.oa10.entity.News;

import java.util.List;

public class AnnoAdapter extends BaseAdapter {
    private List<Announcement.AnnouncementBean> list;
    private Context context;

    //通过构造方法接受要显示的新闻数据集合
    public AnnoAdapter(Context context, List<Announcement.AnnouncementBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(convertView != null){
            view = convertView;
        }else {
            view = View.inflate(context, R.layout.item_news_layout, null);//将一个布局文件转换成一个view对象
        }
        //2.获取view上的子控件对象
        ImageView item_img_icon = (ImageView) view.findViewById(R.id.item_img_icon);
        TextView item_tv_des = (TextView) view.findViewById(R.id.item_tv_des);
        TextView item_tv_title = (TextView) view.findViewById(R.id.item_tv_title);
        //3.获取postion位置条目对应的list集合中的新闻数据，Bean对象
        Announcement.AnnouncementBean announcementBean = list.get(position);
        //4.将数据设置给这些子控件做显示
        //item_img_icon.setImageDrawable(newsBean.icon);//设置imageView的图片
        item_tv_title.setText(announcementBean.getAnno_title());
        item_tv_des.setText(announcementBean.getAnno_time());

        return view;
    }
}
