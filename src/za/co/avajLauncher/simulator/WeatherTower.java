package za.co.avajLauncher.simulator;

import za.co.avajLauncher.simulator.vehicles.Coordinates;
import za.co.avajLauncher.weather.WeatherProvider;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {

        this.conditionsChanged();
    }

}
