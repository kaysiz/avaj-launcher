package za.co.avajLauncher.simulator;

import za.co.avajLauncher.simulator.vehicles.AircraftFactory;
import za.co.avajLauncher.simulator.vehicles.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();

            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (Integer.signum(simulations) != 1) {
                    System.out.println("Invalid simulations count, expected a positive number greater than 0!");
                    System.exit(1);
                }
                while ((line = bufferedReader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0],line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable: flyables) {
                    flyable.registerTower(weatherTower);
                }

//                for (int i = 1; i <= simulations; i++) {
//                    Logger.addMessage("this is a test "+ new Random(34));
//                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Path to Scenario file not found!!" + args[0]);
            System.exit(1);
        }catch (IOException e) {
            System.out.println("Something went wrong reading file "+ args[0]);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("A non-integer value was given for number of simulations!!");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify scenario file");
        } finally {
            Logger.logMessage();
        }

    }
}