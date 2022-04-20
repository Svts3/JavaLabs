package ua.lviv.lab.devices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCalculator {

    @Test
    void testToString() {
	Calculator calculator = new Calculator("Casio", "212", 20, 0.5, 12);
	assertEquals(true, calculator.toString().contains("Brand: Casio"));
	assertEquals(true, calculator.toString().contains("model: 212"));
	assertEquals(true, calculator.toString().contains("Dimension: 12"));
	assertEquals(true, calculator.toString().contains("weight: 0,5"));
	assertEquals(true, calculator.toString().contains("Price: 20"));
	
    }

}
