package weather;

public class Weather {

    private String weatherDescription;
    private double temperature;
    private String weatherIconId;

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeatherIconId() {
        return weatherIconId;
    }

    public Weather(String weatherDescription, double temperature, String weatherIconId) {
        this.weatherDescription = weatherDescription;
        this.temperature = temperature;
        this.weatherIconId = weatherIconId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (Double.compare(weather.temperature, temperature) != 0) return false;
        if (weatherDescription != null ? !weatherDescription.equals(weather.weatherDescription) : weather.weatherDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = weatherDescription != null ? weatherDescription.hashCode() : 0;
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
