package weather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cchiappini on 21/03/2015.
 */
public class WeatherOracleTest {

    @Test
    public void testWeatherOracle(){
        WeatherOracle weatherOracle = new WeatherOracle();
        assertEquals(WeatherOracle.SUN_IS_SHINING, weatherOracle.getWeather());
    }
}
