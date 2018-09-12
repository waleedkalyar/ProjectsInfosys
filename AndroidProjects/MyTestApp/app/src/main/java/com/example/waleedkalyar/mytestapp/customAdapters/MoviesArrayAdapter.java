package com.example.waleedkalyar.mytestapp.customAdapters;

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

import com.example.waleedkalyar.mytestapp.R;
import com.example.waleedkalyar.mytestapp.models.MoviesModel;

/**
 * Created by WALEED KALYAR on 8/7/2017.
 */

public class MoviesArrayAdapter extends ArrayAdapter {
    public Context context;
    public int resource;
     public MoviesModel[] moviesData;
    LayoutInflater mLayoutInflater;
    public MoviesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull MoviesModel[] moviesData) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.moviesData=moviesData;
        mLayoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=mLayoutInflater.inflate(resource,null);
        ImageView mThumnail=(ImageView) convertView.findViewById(R.id.thumnail_for_movie);
        TextView mTitle=(TextView) convertView.findViewById(R.id.movies_title);
        TextView mSubtitle=(TextView) convertView.findViewById(R.id.movies_subtitle);
        TextView mLikes=(TextView) convertView.findViewById(R.id.movies_likes);
        TextView mDislikes=(TextView) convertView.findViewById(R.id.movies_dislikes);

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
