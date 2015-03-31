package weather;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static weather.WeatherOracle.ICON_ID;
import static weather.WeatherOracle.SUN_IS_SHINING;
import static weather.WeatherOracle.TEMPERATURE;

public class WeatherOracleTest {

    private WeatherOracle weatherOracle;

    @Before
    public void setup(){
        weatherOracle = new WeatherOracle();
    }

    @Test
    public void shouldReturnASunnyWeather(){
        Weather expectedWeather =
                new Weather(SUN_IS_SHINING, TEMPERATURE, ICON_ID);
        assertEquals(expectedWeather, weatherOracle.getWeather());
    }
}
