package za.co.avajLauncher.simulator.vehicles;

import za.co.avajLauncher.simulator.WeatherTower;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
