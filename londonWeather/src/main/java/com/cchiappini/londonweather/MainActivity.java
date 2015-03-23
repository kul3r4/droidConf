package com.cchiappini.londonweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import weather.WeatherOracle;


public class MainActivity extends Activity {

    public static final String WEATHER_EXTRA = "WEATHER_EXTRA";
    private WeatherOracle weatherOracle = new WeatherOracle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.weather_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String weather = weatherOracle.getWeather();
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra(WEATHER_EXTRA,weather);
                startActivity(intent);
            }
        });
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
