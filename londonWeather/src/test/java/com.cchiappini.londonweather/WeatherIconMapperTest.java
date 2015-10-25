package com.cchiappini.londonweather;

import com.cchiappini.londonweather.exception.IconNotFoundException;

import org.junit.Test;
import org.robolectric.annotation.Config;

import weather.Weather;

import static org.junit.Assert.assertEquals;


@Config(emulateSdk = 23)
public class WeatherIconMapperTest {

    private static final String A_WEATHER_DESCRIPTION = "aWeatherDescription";
    private static final double A_WEATHER_TEMPERATURE = 15.0;
    private static final String SUN_ICON_ID = "sun";
    private static final String UNKNOWN_ICON_ID = "unknownIconId";

    @Test
    public void shouldReturnTheRightIconWhenSunny()
            throws IconNotFoundException {
        Weather weather = new Weather(A_WEATHER_DESCRIPTION,
                A_WEATHER_TEMPERATURE, SUN_ICON_ID);
        int expectedIcon = R.drawable.sun;
        assertEquals(expectedIcon,
                WeatherIconMapper.getIconResourceIdForWeather(weather));
    }

    @Test (expected=IconNotFoundException.class)
    public void shouldThrowAnExceptionWhenIconIsNotFound() throws IconNotFoundException {
        Weather weather = new Weather(A_WEATHER_DESCRIPTION,
                A_WEATHER_TEMPERATURE, UNKNOWN_ICON_ID);
        int expectedIcon = R.drawable.sun;
        assertEquals(expectedIcon,
                WeatherIconMapper.getIconResourceIdForWeather(weather));
    }
}
