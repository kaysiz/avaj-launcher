package za.co.avajLauncher.simulator.vehicles;

import za.co.avajLauncher.simulator.Logger;
import za.co.avajLauncher.simulator.WeatherTower;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    protected Helicopter(String _name, Coordinates _coords) {

        super(_name, _coords);
        if (_coords.getHeight() == 0) {
            Logger.addMessage("landing");
        }
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coords);
        HashMap<String, String> map = new HashMap<>();
        map.put("SUN", "Heli Its hot");
        map.put("RAIN", "Heli Its wet");
        map.put("FOG", "Heli I can not see a bloody thing");
        map.put("SNOW", "Heli Daaaamn its freezing");

        if (weather.equals("SUN")) {
            this.coords = new Coordinates(coords.getLongitude() + 10, coords.getLatitude(), coords.getHeight() + 2);
        } else if(weather.equals("RAIN")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude() + 5, coords.getHeight());
        } else if(weather.equals("FOG")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude() + 1, coords.getHeight());
        } else if(weather.equals("SNOW")) {
            this.coords = new Coordinates(coords.getLongitude(), coords.getLatitude(), coords.getHeight() - 12);
        } else {
            System.out.println("The weather condition is not valid");
            System.exit(1);
        }
        Logger.addMessage(map.get(weather));
        if (this.coords.getHeight() <= 0) {
            Logger.addMessage("Helicopter#" + this.name + "(" + this.id + ") LANDED.");
            Logger.addMessage("Helicopter#" + this.name + "(" + this.id + ") UNREGISTERED FROM WEATHER TOWER.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.addMessage("Tower says Helicopter#: "+ this.name + this.id + " registered to weather tower");
    }
}
