package com.example.android.sunshine.sync;


import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

//  COMPLETED (1) Create a class called SunshineSyncTask
//  COMPLETED (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      COMPLETED (3) Within syncWeather, fetch new weather data
//      COMPLETED (4) If we have valid results, delete the old data and insert the new

public class SunshineSyncTask {

    public static void syncWeather(Context context) {

        try {

            // Gets the URL needed to get the forecast JSON for the weather
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            // Uses the URL to retrieve the JSON
            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            // Parse the JSON into a list of weather values
            ContentValues[] weatherValues = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, jsonWeatherResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}