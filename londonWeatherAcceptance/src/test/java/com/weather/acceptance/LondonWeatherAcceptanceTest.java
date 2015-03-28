package com.weather.acceptance;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import weather.WeatherOracle;

import static org.junit.Assert.assertEquals;
import static weather.WeatherOracle.SUN_IS_SHINING;

public class LondonWeatherAcceptanceTest {

    private WebDriver driver;

    @Before
    public void setup() throws Exception {
        SelendroidConfiguration config = new SelendroidConfiguration();
        config.addSupportedApp("../londonWeather/build/outputs/apk/londonWeather-debug.apk");
        config.setPort(4444);
        SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();

        SelendroidCapabilities capa = new SelendroidCapabilities("com.cchiappini.londonweather");
        driver = new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa);
    }

    @Test
    public void userCanGetWeatherInLondon() {
        WebElement weatherButton = findWeatherButton();

        weatherButton.click();

        WebElement weatherText = findWeatherText();
        assertEquals(SUN_IS_SHINING, weatherText.getText());
    }

    private WebElement findWeatherText() {
        return findElementById("weather_text");
    }

    private WebElement findWeatherButton() {
        return findElementById("weather_button");
    }

    private WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
