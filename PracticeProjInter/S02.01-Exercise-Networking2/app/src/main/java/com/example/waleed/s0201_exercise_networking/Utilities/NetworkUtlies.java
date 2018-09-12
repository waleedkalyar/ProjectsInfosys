package com.example.waleed.s0201_exercise_networking.Utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by waleed on 11/11/2017.
 */

public class NetworkUtlies {
final static String GOOGLE_URL="http://www.google.com";
    final static String PARAM_QUERY="q";
    final static String PARAM_SORT="sort";
    final static String sort_BY="stars";

    public static URL buildUrl(String googleSearchQuery){
        Uri buildUri=Uri.parse(GOOGLE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY,googleSearchQuery)
                .appendQueryParameter(PARAM_SORT,sort_BY)
                .build();

        URL url=null;
        try{
            url=new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponceFronHttpUrl(URL url) throws IOException{
        HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
        try{
            InputStream in=urlConnection.getInputStream();
            Scanner scanner=new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput=scanner.hasNext();
            if(hasInput){
                return scanner.next();
            }else
            {
                return null;
            }
        }
        finally {
            urlConnection.disconnect();
        }
    }

}
