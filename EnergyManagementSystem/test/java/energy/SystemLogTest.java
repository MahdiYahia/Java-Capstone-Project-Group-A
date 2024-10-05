package energy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class SystemLogTest {
    SystemLog systemLog;

    @BeforeEach
    void setUp() {
        systemLog = new SystemLog("2024-10-05");
    }

    @Test
    void testCreateSystemLog() {
        systemLog.createLog();
        File logFile = new File("src/resources/logs/SystemLog_2024-10-05.txt");
        assertTrue(logFile.exists());
    }

    @Test
    void testReadSystemLog() {
        systemLog.createLog();
        systemLog.readLog();
        File logFile = new File("src/resources/logs/SystemLog_2024-10-05.txt");
        assertTrue(logFile.exists());
    }

    @Test
    void testDeleteSystemLog() {
        systemLog.createLog();
        systemLog.deleteLog();
        File logFile = new File("src/resources/logs/SystemLog_2024-10-05.txt");
        assertFalse(logFile.exists());
    }

    @Test
    void testMoveSystemLog() {
        systemLog.createLog();
        systemLog.moveLogFile("src/resources/archived_logs/");
        File movedFile = new File("src/resources/archived_logs/SystemLog_2024-10-05.txt");
        assertTrue(movedFile.exists());
    }
}
