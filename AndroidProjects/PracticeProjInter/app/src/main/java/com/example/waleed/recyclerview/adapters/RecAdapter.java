package com.example.waleed.recyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.waleed.recyclerview.ColorUtils;
import com.example.waleed.recyclerview.R;

/**
 * Created by waleed on 3/27/2018.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.StateViewHolder> {
private int numberItems;
private static int viewHolderCount;
    public RecAdapter(int noOfItems){
        numberItems=noOfItems;
        viewHolderCount=0;
    }

    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        int layoutForListItem=R.layout.list_item;
        View view=inflater.inflate(layoutForListItem,parent,false);
        StateViewHolder viewHolder= new StateViewHolder(view);
        viewHolder.viewHolderIndex.setText(String.valueOf(viewHolderCount) );
        viewHolder.listTextViewAlpha.setText("Welcome to Garden");
        int backgroundColorForViewHolder = ColorUtils
                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StateViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }


    class StateViewHolder extends RecyclerView.ViewHolder{
TextView listTextViewAlpha;
        TextView viewHolderIndex;
        public StateViewHolder(View itemView) {
            super(itemView);
            viewHolderIndex=(TextView) itemView.findViewById(R.id.item_text);
            listTextViewAlpha=(TextView) itemView.findViewById(R.id.item_text_alpha);
        }
        void bind(int listIndex){
            viewHolderIndex.setText(String.valueOf(listIndex));
        }
    }
}
