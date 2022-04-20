package ua.lviv.lab.devices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSmartphone {

    @Test
    void testToString() {
	Smartphone smartphone = new Smartphone("Samsung", "Note", 1000, 0.7, "Samsung Exynos",
						"Samsung Xclipse 920", 8, 64, 6.7, 5000, 3);
	assertEquals(true, smartphone.toString().contains("Brand: Samsung"));
	assertEquals(true, smartphone.toString().contains("model: Note"));
	assertEquals(true, smartphone.toString().contains("CPU: Samsung Exynos"));
	assertEquals(true, smartphone.toString().contains("video core: Samsung Xclipse 920"));
	assertEquals(true, smartphone.toString().contains("RAM: 8"));
	assertEquals(true, smartphone.toString().contains("weight: 0,7"));
	assertEquals(true, smartphone.toString().contains("Price: 1000"));
    }

}
