package com.cchiappini.londonweather;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by cchiappini on 11/10/15.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
    MainActivity.class, true, false);

  @Test
  public void showTemperature() {
    activityRule.launchActivity(new Intent());
    onView(withId(R.id.weather_temp))
      .check(matches(withText("15")));
  }

}
