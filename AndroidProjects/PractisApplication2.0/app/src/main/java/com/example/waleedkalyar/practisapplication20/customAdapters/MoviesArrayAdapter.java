package com.example.waleedkalyar.practisapplication20.customAdapters;

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

import com.example.waleedkalyar.practisapplication20.R;
import com.example.waleedkalyar.practisapplication20.dataModels.MoviesModels;

/**
 * Created by WALEED KALYAR on 8/6/2017.
 */

public class MoviesArrayAdapter  extends ArrayAdapter{
    Context context;
    int resource;
    MoviesModels[] moviesData;
    LayoutInflater mLayoutInflator;
    public MoviesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull MoviesModels[] moviesData) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.moviesData=moviesData;
        mLayoutInflator=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=mLayoutInflator.inflate(resource,null);
        ImageView mThumnail=(ImageView)convertView.findViewById(R.id.img_vu_movies_thumbnail);
        TextView mTitle=(TextView) convertView.findViewById(R.id.txt_vu_movies_title);
        TextView mSubtitle=(TextView) convertView.findViewById(R.id.txt_vu_movies_subtitle);
        TextView mLikes=(TextView) convertView.findViewById(R.id.txt_vu_movies_likes);
        TextView mDislikes=(TextView) convertView.findViewById(R.id.txt_vu_movies_dislikes);
        mThumnail.setImageResource(moviesData[position].mThumnail);
        mTitle.setText(moviesData[position].title);
        mSubtitle.setText(moviesData[position].subTitle);
        mLikes.setText(moviesData[position].likes);
        mDislikes.setText(moviesData[position].disLikes);


        return convertView;



    }

    @Override
    public int getCount() {
        return moviesData.length;
    }
}
