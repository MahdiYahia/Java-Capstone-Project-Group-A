package energy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemLog {
    private String date;
    private String logDirectory = "src/resources/logs/";

    public SystemLog(String date) {
        this.date = date;
    }

    // Method to create a system-wide log
    public void createLog() {
        String fileName = logDirectory + "SystemLog_" + date + ".txt";
        File logFile = new File(fileName);

        try {
            if (logFile.createNewFile()) {
                System.out.println("System log file created: " + logFile.getName());
            } else {
                System.out.println("System log file already exists.");
            }

            // Example: Summarize data for all stations and energy sources
            FileWriter writer = new FileWriter(logFile);
            writer.write("System-wide Log for Date: " + date + "\n");
            writer.write("Total Energy Consumed: 500 kWh\n");  // Example summary
            writer.write("Total Charging Sessions: 100\n");    // Example summary
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred while creating the system log file.");
            e.printStackTrace();
        }
    }

    // Method to read the system log file
    public void readLog() {
        String fileName = logDirectory + "SystemLog_" + date + ".txt";
        File logFile = new File(fileName);

        try {
            Scanner reader = new Scanner(logFile);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the system log file.");
            e.printStackTrace();
        }
    }

    // Method to delete the system log file
    public void deleteLog() {
        String fileName = logDirectory + "SystemLog_" + date + ".txt";
        File logFile = new File(fileName);

        if (logFile.exists() && logFile.delete()) {
            System.out.println("System log file deleted.");
        } else {
            System.out.println("System log file not found or failed to delete.");
        }
    }

    // Method to move the system log file to a different directory
    public void moveLogFile(String newDirectory) {
        String fileName = logDirectory + "SystemLog_" + date + ".txt";
        File logFile = new File(fileName);
        File newDir = new File(newDirectory);

        if (logFile.exists()) {
            if (logFile.renameTo(new File(newDir, logFile.getName()))) {
                System.out.println("System log file moved to " + newDirectory);
            } else {
                System.out.println("Failed to move system log file.");
            }
        } else {
            System.out.println("System log file not found.");
        }
    }
}
