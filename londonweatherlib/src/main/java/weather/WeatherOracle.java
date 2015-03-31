package weather;

public class WeatherOracle {

    public static final String SUN_IS_SHINING = "Sun is shining";
    public static final double TEMPERATURE = 15.0;
    public static final String ICON_ID = "sun";

    public Weather getWeather() {
        return new Weather(SUN_IS_SHINING, TEMPERATURE, ICON_ID);
    }
}
