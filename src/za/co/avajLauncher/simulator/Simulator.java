package za.co.avajLauncher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

    public static void main(String[] args) {
	// write your code here
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();

            if (line != null) {

                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations <= 0) {
                    System.exit(1);
                }
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}