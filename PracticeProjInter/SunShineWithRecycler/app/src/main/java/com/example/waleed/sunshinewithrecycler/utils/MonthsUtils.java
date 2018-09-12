package com.example.waleed.sunshinewithrecycler.utils;

/**
 * Created by waleed on 11/13/2017.
 */

public class MonthsUtils {

    public static String getViewHolderMonth(int monthNumber){
        switch (monthNumber){
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUUG";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";
        }
        return "ERROR";
    }
}
