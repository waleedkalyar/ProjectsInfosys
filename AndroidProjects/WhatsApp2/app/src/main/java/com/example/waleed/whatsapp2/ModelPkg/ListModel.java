package com.example.waleed.whatsapp2.ModelPkg;

/**
 * Created by waleed on 9/16/2017.
 */

public class ListModel {
    public int imgUser;
    public int imgMsg;
    public String userName;
    public String lastMsg;

    public ListModel(int imgUser, int imgMsg, String userName, String lastMsg) {
        this.imgUser = imgUser;
        this.imgMsg = imgMsg;
        this.userName = userName;
        this.lastMsg = lastMsg;
    }
}
