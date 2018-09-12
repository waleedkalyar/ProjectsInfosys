package com.example.waleed.whatsapp2.adaptersPkg;

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

import com.example.waleed.whatsapp2.ModelPkg.ListModel;
import com.example.waleed.whatsapp2.R;

/**
 * Created by waleed on 9/16/2017.
 */

public class ListAdapter extends ArrayAdapter {
    Context context;
     int resource;
     ListModel[] ListModel;
    LayoutInflater mInflater;
    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ListModel[] whatsArray) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.ListModel=ListModel;
         mInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=  mInflater.inflate(resource,null);
        ImageView personImg=(ImageView) convertView.findViewById(R.id.img_vu_lst);
        ImageView MsgImg=(ImageView) convertView.findViewById(R.id.msg_status_lst);
        TextView userName=(TextView) convertView.findViewById(R.id.user_name_lst);
        TextView userMsg=(TextView) convertView.findViewById(R.id.user_sms_lst);

        personImg.setImageResource(ListModel[position].imgUser);
        MsgImg.setImageResource(ListModel[position].imgMsg);
        userName.setText(ListModel[position].userName);
        userMsg.setText(ListModel[position].lastMsg);
        return convertView;
    }

    @Override
    public int getCount() {
        return ListModel.length;
    }
}
