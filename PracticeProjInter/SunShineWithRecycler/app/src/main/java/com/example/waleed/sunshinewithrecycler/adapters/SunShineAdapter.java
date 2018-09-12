package com.example.waleed.sunshinewithrecycler.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.waleed.sunshinewithrecycler.R;
import com.example.waleed.sunshinewithrecycler.utils.DayUtils;
import com.example.waleed.sunshinewithrecycler.utils.MonthsUtils;
import com.example.waleed.sunshinewithrecycler.utils.WeatherConditionUtils;

/**
 * Created by waleed on 11/12/2017.
 */

public class SunShineAdapter extends RecyclerView.Adapter<SunShineAdapter.RowViewHolder>{

    private static final String TAG=SunShineAdapter.class.getSimpleName();

    final private ListItemClickListner mOnClickListner;
    private int date;
    private int month;
    private int weatherConditionNumbers;
// now the string var are initilized

    private static int viewHolderCount;

    public SunShineAdapter(int date,int month,int weatherConditionNumbers,ListItemClickListner listner) {
        this.date=date;
        this.month=month;
        this.weatherConditionNumbers=weatherConditionNumbers;
        this.mOnClickListner=listner;
        viewHolderCount=0;
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        int layoutIdForListItem= R.layout.row_style_sun_shine;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately=false;

        View view=inflater.inflate(layoutIdForListItem,parent,shouldAttachToParentImmediately);
        RowViewHolder viewHolder=new RowViewHolder(view);



        //complete here the work is remaning these vars day and weather will used  in RowViewHolder class

    String        day= DayUtils.getViewHolderDay(context,date);
          String  weatherCondition= WeatherConditionUtils.getWeatherCondition(context,weatherConditionNumbers);
           String monthString= MonthsUtils.getViewHolderMonth(month);
            viewHolder.dayView.setText(day);
            viewHolder.monthView.setText(monthString);
            viewHolder.weatherConditionView.setText(weatherCondition);
       date++;
        if(date==30){
            month++;
        date=1;
        weatherConditionNumbers=1;
        }
        weatherConditionNumbers++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RowViewHolder holder, int position) {
        holder.bind(position,date,weatherConditionNumbers,month);
      // Complete(2) here also work remaining

    }


    @Override
    public int getItemCount() {
        return date;
    }

    public interface ListItemClickListner{
        void onListItemClick(int clickedItemIndex);
    }

    class RowViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
TextView dayView,monthView,dateView,weatherConditionView,weatherConditionInNumberView,positionTv;

     public RowViewHolder(View itemView) {
         super(itemView);
positionTv=(TextView) itemView.findViewById(R.id.position);
         dayView=(TextView)itemView.findViewById(R.id.day);
         monthView=(TextView)itemView.findViewById(R.id.month);
         dateView=(TextView)itemView.findViewById(R.id.date);
         weatherConditionView=(TextView)itemView.findViewById(R.id.weather_condition);
         weatherConditionInNumberView=(TextView)itemView.findViewById(R.id.weather_condition_in_numbers);

         itemView.setOnClickListener(this);
     }
     void bind(int position, int date, int weatherConditionInNumbers,int month){
         positionTv.setText(String.valueOf(position));
         weatherConditionInNumberView.setText(String.valueOf(weatherConditionInNumbers));
         dateView.setText(String.valueOf(date));
        // monthView.setText(monthString1);
         //dayView.setText(day1);
         //weatherConditionView.setText(weatherCondition1);
         //dateView.setText(String.valueOf(date1));
         //weatherConditionInNumberView.setText(String.valueOf(weatherConditionInNumbers1));

         //day,weatherCondition,monthString
        // dateView.setText(String.valueOf(date));
         //weatherConditionInNumberView.setText(String.valueOf(weatherConditionInNumbers));
     }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListner.onListItemClick(clickedPosition);
        }
    }
}
