package com.example.waleedkalyar.mytestapp.models;

/**
 * Created by WALEED KALYAR on 8/7/2017.
 */

public class MoviesModel {
    public int thumbnail;
    public String title;
    public String subTitle;
    public String likes;
    public String disLikes;

    public MoviesModel(int thumbnail, String title, String subTitle, String likes, String disLikes) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.likes = likes;
        this.disLikes = disLikes;
    }
}
