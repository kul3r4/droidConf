package com.weather.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import static org.junit.Assert.assertEquals;
import static weather.WeatherOracle.SUN_IS_SHINING;

public class LondonWeatherAcceptanceTest {

    public static final String WEATHER_TEMP = "weather_temp";
    private static final String WEATHER_DESCRIPTION = "weather_description";
    private static final String EXPECTED_TEMPERATURE = "15";
    private WebDriver driver;

    @Before
    public void setup() throws Exception {
        SelendroidConfiguration config = new SelendroidConfiguration();
        //mine is /Users/cchiappini/IProjects/droidConfRefactor
        // /londonWeather/build/outputs/apk/londonWeather-debug.apk
        String apkPath = System.getProperty("apkPath");
        //aut is for me "com.cchiappini.londonweather"
        String aut = System.getProperty("aut");
        //my hubURL is http://localhost:4444/wd/hub
        String hubUrl = System.getProperty("hubURL");
        config.addSupportedApp(apkPath);
        config.setPort(4444);
        SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();


        SelendroidCapabilities capa = new SelendroidCapabilities(aut);
        //capa.setPlatformVersion(DeviceTargetPlatform.ANDROID18);
        driver = new SelendroidDriver(new URL(hubUrl), capa);
    }

    @Test
    public void userCanGetWeatherDescription() {
        WebElement weatherText = findWeatherText();
        assertEquals(SUN_IS_SHINING, weatherText.getText());
    }

    @Test
    public void userCanGetWeatherTemperature() {
        WebElement weatherTemp = findTemperatureText();
        assertEquals(EXPECTED_TEMPERATURE, weatherTemp.getText());
    }


    private WebElement findTemperatureText() {
        return findElementById(WEATHER_TEMP);
    }

    private WebElement findWeatherText() {
        return findElementById(WEATHER_DESCRIPTION);
    }

    private WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
