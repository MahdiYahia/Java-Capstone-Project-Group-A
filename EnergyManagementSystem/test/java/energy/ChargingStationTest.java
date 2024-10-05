package energy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChargingStationTest {
    ChargingStation station;
    EnergySource solarSource;

    @BeforeEach
    void setUp() {
        solarSource = new EnergySource("Solar", 100);
        station = new ChargingStation("Station1", solarSource);
    }

    @Test
    void testGetStationName() {
        assertEquals("Station1", station.getStationName());
    }

    @Test
    void testGetEnergySource() {
        assertEquals("Solar", station.getEnergySource().getSourceName());
    }

    @Test
    void testGetEnergyUsage() {
        assertEquals(100, station.getEnergySource().getEnergyUsage());
    }

    @Test
    void testSetEnergyUsage() {
        station.getEnergySource().setEnergyUsage(200);
        assertEquals(200, station.getEnergySource().getEnergyUsage());
    }
}
