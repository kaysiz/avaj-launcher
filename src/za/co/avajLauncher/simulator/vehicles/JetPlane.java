package za.co.avajLauncher.simulator.vehicles;

import za.co.avajLauncher.simulator.Logger;
import za.co.avajLauncher.simulator.WeatherTower;

import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String _name, Coordinates _coords) {
        super(_name, _coords);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coords);
        HashMap<String, String> map = new HashMap<>();
        map.put("SUN", "Its hot");
        map.put("RAIN", "Its wet");
        map.put("FOG", "I can not see a bloody thing");
        map.put("SNOW", "Daaaamn its freezing");
        if (weather.equals("SUN")) {
            this.coords = new Coordinates(coords.getLongitude() + 10, coords.getLatitude(), coords.getHeight() + 2);
        } else if(weather.equals("RAIN")) {
            this.coords = new Coordinates(coords.getLongitude() + 5, coords.getLatitude(), coords.getHeight());
        } else if(weather.equals("FOG")) {
            this.coords = new Coordinates(coords.getLongitude() + 1, coords.getLatitude(), coords.getHeight());
        } else if(weather.equals("SNOW")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude(), coords.getHeight() - 7);
        } else {
            System.out.println("The weather condition is not valid");
            System.exit(1);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.addMessage("Tower says JetPlane#: "+ this.name + this.id + " registered to weather tower");
    }
}
