package energy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class LogManagerTest {
    LogManager logManager;

    @BeforeEach
    void setUp() {
        logManager = new LogManager();
    }

    @Test
    void testCreateLogFile() {
        logManager.createLogFile("Station1", "Solar", "2024-10-05");
        File logFile = new File("src/resources/logs/Station1_Solar_2024-10-05.txt");
        assertTrue(logFile.exists());
    }

    @Test
    void testReadLogFile() {
        logManager.createLogFile("Station1", "Solar", "2024-10-05");
        String content = logManager.readLogFile("Station1", "Solar", "2024-10-05");
        assertNotNull(content);
        assertTrue(content.contains("Station: Station1"));
    }

    @Test
    void testDeleteLogFile() {
        logManager.createLogFile("Station1", "Solar", "2024-10-05");
        logManager.deleteLogFile("Station1", "Solar", "2024-10-05");
        File logFile = new File("src/resources/logs/Station1_Solar_2024-10-05.txt");
        assertFalse(logFile.exists());
    }
}
