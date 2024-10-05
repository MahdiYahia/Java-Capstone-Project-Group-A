package energy;

public class EMSMain {
    public static void main(String[] args) {
        // Create instances of Charging Station
        ChargingStation station1 = new ChargingStation("Station1");

        // Create instances of Energy Sources (Solar and Supply)
        EnergySource solar = new EnergySource("Solar");
        EnergySource supply = new EnergySource("Supply");

        // Create LogManager instance
        LogManager logManager = new LogManager();

        // Example: Create log files for each energy source on a specific day
        logManager.createLogFile(station1.getStationName(), solar.getSourceName(), "2023-10-05");
        logManager.createLogFile(station1.getStationName(), supply.getSourceName(), "2023-10-05");

        // Example: Create a system-wide log
        logManager.createSystemLog("2023-10-05");

        // Example: Read log file for "Supply" energy source
        logManager.readLogFile(station1.getStationName(), supply.getSourceName(), "2023-10-05");

        // Example: Search log files by equipment
        logManager.searchLogFilesByEquipment("Station1");

        // Example: Search log files by date
        logManager.searchLogFilesByDate("2023-10-05");

        // Example: Delete a log file
        logManager.deleteLogFile(station1.getStationName(), supply.getSourceName(), "2023-10-05");

        // Example: Move log file to a different directory
        logManager.moveLogFile(station1.getStationName(), supply.getSourceName(), "2023-10-05", "src/resources/archive/");
    }
}
