package ua.lviv.lab.devices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPC {

    @Test
    void testToString() {
	PC pc = new PC("Asus", "S-500", 1500, 3.4, "R5 5600x", "RTX 3060", 16, 1000);
	assertEquals(true, pc.toString().contains("Brand: Asus"));
	assertEquals(true, pc.toString().contains("model: S-500"));
	assertEquals(true, pc.toString().contains("weight: 3,4"));	
	assertEquals(true, pc.toString().contains("CPU: R5 5600x"));
	assertEquals(true, pc.toString().contains("GPU: RTX 3060"));
	assertEquals(true, pc.toString().contains("RAM: 16"));
	assertEquals(true, pc.toString().contains("Price: 1500"));
	assertEquals(true, pc.toString().contains("Memory: 1000"));
    }

}
