package com.weather.acceptance;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import weather.WeatherOracle;

public class LondonWeatherAcceptanceTest {

  private WebDriver driver;

  @Before
  public void setup() throws Exception {
    SelendroidConfiguration config = new SelendroidConfiguration();
    config.addSupportedApp("/Users/cchiappini/IProjects/droidConf/londonWeather/build/outputs/apk/londonWeather-debug.apk");
    config.setPort(4444);
    SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
    selendroidServer.launchSelendroid();

    SelendroidCapabilities capa = new SelendroidCapabilities("com.cchiappini.londonweather");
    driver = new SelendroidDriver(capa);
  }

  @Test
  public void userCanGetWeatherInLondon() {
    WebElement weatherButton = driver.findElement(By.id("weather_button"));
    Assert.assertTrue(weatherButton.isDisplayed());
    weatherButton.click();
    WebElement weatherText = driver.findElement(By.id("weather_text"));
    Assert.assertEquals(WeatherOracle.SUN_IS_SHINING, weatherText.getText());
  }

  @After
  public void tearDown(){
    driver.quit();
  }
}
