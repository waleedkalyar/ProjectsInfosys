package com.example.waleed.projectsunshine.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.waleed.projectsunshine.R;

/**
 * Created by waleed on 11/21/2017.
 */

public class ForcastAdapter extends RecyclerView.Adapter<ForcastAdapter.ForcastAdapterViewHolder>{
private String[] mWeatherData;

    final private ForcastAdapterOnClickHandler mClickHandler;

    public ForcastAdapter(ForcastAdapterOnClickHandler mClickHandler) {
        this.mClickHandler = mClickHandler;
    }



    public interface ForcastAdapterOnClickHandler{
        public void onClick(String weatherForDay);
    }

    @Override
    public ForcastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int layoutIdForListItem=R.layout.forcast_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachToParentImmidiately=false;

        View view=inflater.inflate(layoutIdForListItem,parent,shouldAttachToParentImmidiately);
        return new ForcastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForcastAdapterViewHolder holder, int position) {
        String weatherForThisDay=mWeatherData[position];
        holder.mWeatherTextView.setText(weatherForThisDay);

    }

    @Override
    public int getItemCount() {
        if (mWeatherData==null)
        return 0;
        else
            return mWeatherData.length;
    }

    public class ForcastAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

       public final TextView mWeatherTextView;
        public ForcastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView=(TextView) view.findViewById(R.id.tv_weather_data);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition=getAdapterPosition();
            String weatherForDay=mWeatherData[adapterPosition];
            mClickHandler.onClick(weatherForDay);
        }
    }

    public void setWeatherData(String[] weatherData){
        mWeatherData=weatherData;
        notifyDataSetChanged();
    }
}
