package weather;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static weather.WeatherOracle.SUN_IS_SHINING;

/**
 * Created by cchiappini on 21/03/2015.
 */
public class WeatherOracleTest {

    private WeatherOracle weatherOracle;

    @Before
    public void setup(){
        weatherOracle = new WeatherOracle();
    }

    @Test
    public void testWeatherOracle(){
        assertEquals(SUN_IS_SHINING, weatherOracle.getWeather());
    }
}
