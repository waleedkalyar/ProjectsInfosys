package com.example.waleedkalyar.fragmentpractisehomework.customAdapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waleedkalyar.fragmentpractisehomework.R;
import com.example.waleedkalyar.fragmentpractisehomework.newsModel.NewsModel;

/**
 * Created by WALEED KALYAR on 8/31/2017.
 */

public class NewsAdapter extends ArrayAdapter {
    Context context;
    int resource;
    NewsModel[] newsModel;
    LayoutInflater newInflator;
    public NewsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull NewsModel[] newsModel) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.newsModel=newsModel;
        newInflator=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=newInflator.inflate(resource,null);
        TextView newsTitle=(TextView) convertView.findViewById(R.id.txtvu_news_title);
        ImageView iThumbnail=(ImageView) convertView.findViewById(R.id.news_thumbnail);

        iThumbnail.setImageResource(newsModel[position].thumbnail);
        newsTitle.setText(newsModel[position].title);
        return convertView;
    }

    @Override
    public int getCount() {
        return newsModel.length;
    }
}
