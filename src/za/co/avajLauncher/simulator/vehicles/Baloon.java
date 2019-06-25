package za.co.avajLauncher.simulator.vehicles;

import za.co.avajLauncher.simulator.Logger;
import za.co.avajLauncher.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String _name, Coordinates _coords) {
        super(_name, _coords);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coords);

        if (weather.equals("SUN")) {
            this.coords = new Coordinates(coords.getLongitude() + 2, coords.getLatitude(), coords.getHeight() + 4);
        } else if(weather.equals("RAIN")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude(), coords.getHeight() - 5);
        } else if(weather.equals("FOG")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude(), coords.getHeight() - 3);
        } else if(weather.equals("SNOW")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude(), coords.getHeight() - 15);
        } else {
            System.out.println("The weather condition is not valid");
            System.exit(1);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.addMessage("Tower says Baloon#: "+ this.name + this.id + " registered to weather tower");
    }
}
