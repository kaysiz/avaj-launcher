package za.co.avajLauncher.simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    public static List<String> messages = new ArrayList<String>();

    public static void logMessage() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("simulation.txt"));
            for(String msg: messages){
                bufferedWriter.write(msg);
                bufferedWriter.append('\n');
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong reading file 'simulation.txt' ");
            System.exit(1);
        }
    }

    public static void addMessage(String message) {
        messages.add(message);
    }
}
