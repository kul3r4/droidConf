package com.cchiappini.londonweather;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.cchiappini.londonweather.exception.IconNotFoundException;

import weather.Weather;
import weather.WeatherOracle;

import static com.cchiappini.londonweather.R.id.weather_description;
import static com.cchiappini.londonweather.R.id.weather_icon;
import static com.cchiappini.londonweather.R.id.weather_temp;
import static com.cchiappini.londonweather.R.id.weather_toolbar;
import static com.cchiappini.londonweather.R.layout.activity_main;


public class MainActivity extends ActionBarActivity {

    public static final String WEATHER_EXTRA = "WEATHER_EXTRA";
    public static final String MAIN_ACTIVITY = "MainActivity";

    private WeatherOracle weatherOracle = new WeatherOracle();
    private Toolbar toolbar;
    private TextView tempView;
    private TextView descriptionView;
    private ImageView iconView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        Weather currentWeather = getWeather();
        String weatherDescription = currentWeather.getWeatherDescription();
        toolbar = (Toolbar) findViewById(weather_toolbar);
        toolbar.setTitle("Richmond");
        setSupportActionBar(toolbar);

        tempView =(TextView) findViewById(weather_temp);
        tempView.setText(String.format("%.0f",currentWeather.getTemperature()));

        descriptionView = (TextView) findViewById(weather_description);
        descriptionView.setText(weatherDescription);

        iconView = (ImageView) findViewById(weather_icon);
        try {
            iconView.setImageResource(WeatherIconMapper.getIconResourceIdForWeather(currentWeather));
        } catch (IconNotFoundException e) {
            Log.e(MAIN_ACTIVITY, "no icon found for weather "+currentWeather);
        }
    }

    private Weather getWeather() {
        return weatherOracle.getWeather();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
