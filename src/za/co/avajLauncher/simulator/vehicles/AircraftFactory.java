package za.co.avajLauncher.simulator.vehicles;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type.toLowerCase()){
            case "helicopter":
                return new Helicopter(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
            case "baloon":
                return new Baloon(name, coordinates);
            default:
                System.out.println("Incorrect aircraft specified, check scenario file and try again.");
                System.exit(1);
        }
        return null;
    }
}
