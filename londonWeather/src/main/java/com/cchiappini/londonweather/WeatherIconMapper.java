package com.cchiappini.londonweather;

import com.cchiappini.londonweather.exception.IconNotFoundException;

import weather.Weather;

public class WeatherIconMapper {

    public static int getIconResourceIdForWeather(Weather weather) throws IconNotFoundException {
        if(weather.getWeatherIconId().equals("sun")) {
            return R.drawable.sun;
        }
        throw new IconNotFoundException();
    }
}
