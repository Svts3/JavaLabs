package ua.lviv.lab.devices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLaptop {

    @Test
    void testToString() {

	Laptop laptop = new Laptop("Dell", "XPS", 1650, 2.7, "R5 5600", "Rtx 3050", 16, 512, 72,
		17);
	assertEquals(true, laptop.toString().contains("Brand: Dell"));
	assertEquals(true, laptop.toString().contains("model: XPS"));
	assertEquals(true, laptop.toString().contains("CPU: R5 5600"));
	assertEquals(true, laptop.toString().contains("GPU: Rtx 3050"));
	assertEquals(true, laptop.toString().contains("Screen diagonal: 17,0"));
	assertEquals(true, laptop.toString().contains("Battery capacity: 72,0"));
	assertEquals(true, laptop.toString().contains("weight: 2,7"));
	assertEquals(true, laptop.toString().contains("Price: 1650"));
    }

}
