package com.cchiappini.londonweather;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

@RunWith(com.cchiappini.londonweather.RobolectricGradleTestRunner.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Activity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void testMainActivity() {
        assertNotNull(mainActivity.findViewById(R.id.weather_toolbar));
        assertNotNull(mainActivity.findViewById(R.id.weather_description));
        assertNotNull(mainActivity.findViewById(R.id.weather_temp));
        assertNotNull(mainActivity.findViewById(R.id.weather_icon));
    }

}
