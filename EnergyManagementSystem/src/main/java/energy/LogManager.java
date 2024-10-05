package energy;

import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class LogManager {

    // Method to create and write a log file
    public void createLogFile(String stationName, String sourceName, String date) {
        String fileName = "src/resources/logs/" + stationName + "_" + sourceName + "_" + date + ".txt";
        File logFile = new File(fileName);

        try {
            if (logFile.createNewFile()) {
                System.out.println("Log file created: " + logFile.getName());
            } else {
                System.out.println("Log file already exists.");
            }

            // Write some example metadata to the file using byte stream
            String logContent = "Charging Station: " + stationName + "\n"
                                + "Energy Source: " + sourceName + "\n"
                                + "Date: " + date + "\n"
                                + "Energy Consumed: 150 kWh\n"
                                + "Charging Sessions: 35\n";
            byte[] bytes = logContent.getBytes();

            FileOutputStream fos = new FileOutputStream(logFile);
            fos.write(bytes);
            fos.close();

        } catch (IOException e) {
            System.out.println("An error occurred while creating the log file.");
            e.printStackTrace();
        }
    }

    // Method to create a system-wide log
    public void createSystemLog(String date) {
        String fileName = "src/resources/logs/SystemLog_" + date + ".txt";
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
            writer.write("Total Energy Consumed: 500 kWh\n");
            writer.write("Total Charging Sessions: 100\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred while creating the system log file.");
            e.printStackTrace();
        }
    }

    // Method to read a log file
    public void readLogFile(String stationName, String sourceName, String date) {
        String fileName = "src/resources/logs/" + stationName + "_" + sourceName + "_" + date + ".txt";
        File logFile = new File(fileName);

        try {
            Scanner reader = new Scanner(logFile);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the log file.");
            e.printStackTrace();
        }
    }

    // Method to delete a log file
    public void deleteLogFile(String stationName, String sourceName, String date) {
        String fileName = "src/resources/logs/" + stationName + "_" + sourceName + "_" + date + ".txt";
        File logFile = new File(fileName);

        if (logFile.exists() && logFile.delete()) {
            System.out.println("Log file deleted.");
        } else {
            System.out.println("Log file not found or failed to delete.");
        }
    }

    // Method to move a log file to a different directory
    public void moveLogFile(String stationName, String sourceName, String date, String newDirectory) {
        String fileName = "src/resources/logs/" + stationName + "_" + sourceName + "_" + date + ".txt";
        File logFile = new File(fileName);
        File newDir = new File(newDirectory);

        if (logFile.exists()) {
            if (logFile.renameTo(new File(newDir, logFile.getName()))) {
                System.out.println("Log file moved to " + newDirectory);
            } else {
                System.out.println("Failed to move log file.");
            }
        } else {
            System.out.println("Log file not found.");
        }
    }

    // Method to search log files by equipment (station name)
    public void searchLogFilesByEquipment(String stationName) {
        File dir = new File("src/resources/logs/");
        File[] files = dir.listFiles((d, name) -> name.startsWith(stationName));

        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("Found log: " + file.getName());
            }
        } else {
            System.out.println("No logs found for station: " + stationName);
        }
    }

    // Method to search log files by date
    public void searchLogFilesByDate(String date) {
        File dir = new File("src/resources/logs/");
        File[] files = dir.listFiles((d, name) -> name.endsWith(date + ".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("Found log: " + file.getName());
            }
        } else {
            System.out.println("No logs found for date: " + date);
        }
    }
}
