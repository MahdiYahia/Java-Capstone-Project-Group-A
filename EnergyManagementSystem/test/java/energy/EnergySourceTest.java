package energy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnergySourceTest {
    EnergySource energySource;

    @BeforeEach
    void setUp() {
        energySource = new EnergySource("Solar", 150);
    }

    @Test
    void testGetSourceName() {
        assertEquals("Solar", energySource.getSourceName());
    }

    @Test
    void testGetEnergyUsage() {
        assertEquals(150, energySource.getEnergyUsage());
    }

    @Test
    void testSetEnergyUsage() {
        energySource.setEnergyUsage(200);
        assertEquals(200, energySource.getEnergyUsage());
    }

    @Test
    void testSetSourceName() {
        energySource.setSourceName("Supply");
        assertEquals("Supply", energySource.getSourceName());
    }
}
