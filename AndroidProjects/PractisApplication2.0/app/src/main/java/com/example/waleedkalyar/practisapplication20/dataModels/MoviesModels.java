package com.example.waleedkalyar.practisapplication20.dataModels;

/**
 * Created by WALEED KALYAR on 8/6/2017.
 */

public class MoviesModels {
    public int mThumnail;
    public String title;
    public String subTitle;
    public String likes;
    public String disLikes;
// press ALT+Insert to create constructor.
    public MoviesModels(int mThumnail ,String title, String subTitle, String likes, String disLikes) {
        this.mThumnail=mThumnail;
        this.title = title;
        this.subTitle = subTitle;
        this.likes = likes;
        this.disLikes = disLikes;
    }
}
