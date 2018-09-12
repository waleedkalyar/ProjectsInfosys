package com.example.waleed.sunshinewithrecycler.utils;

import android.content.Context;

/**
 * Created by waleed on 11/12/2017.
 */

public class WeatherConditionUtils {

    public static String getWeatherCondition(Context context, int weatherCondition){
        switch (weatherCondition){
            case 1:
                return "CLEAR";
            case 2:
                return "CLOUDY";
            case 3:
                return "MOST CLOUDY";
            case 4:
                return "RAINY";
        }
        return "ERROR";
    }
}
