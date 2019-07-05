package za.co.avajLauncher.weather;

import za.co.avajLauncher.simulator.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomNum = 0;
        if(coordinates.getHeight() > 0 && coordinates.getLongitude() > 0 && coordinates.getLatitude() > 0) {
            Random rand = new Random();
            randomNum = rand.nextInt(4);
        }
        return weather[randomNum];
    }
}
