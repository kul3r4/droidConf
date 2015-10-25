package com.cchiappini.londonweather;

import android.app.Activity;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

@Config(emulateSdk = 23)
@RunWith(com.cchiappini.londonweather.RobolectricGradleTestRunner.class)
public class MainActivityTest {

    private Activity mainActivity;


    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Ignore
    @Test
    public void testMainActivity() {
        assertNotNull(mainActivity.findViewById(R.id.weather_toolbar));
        assertNotNull(mainActivity.findViewById(R.id.weather_description));
        assertNotNull(mainActivity.findViewById(R.id.weather_temp));
        assertNotNull(mainActivity.findViewById(R.id.weather_icon));
    }

}
