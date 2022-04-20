package ua.lviv.lab.devices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPrinter {

    @Test
    void testToString() {
	Printer printer = new Printer("Canon", "Pixma", 300, 2.3, "Inkjet printing", 4);
	assertEquals(true, printer.toString().contains("Brand: Canon"));
	assertEquals(true, printer.toString().contains("model: Pixma"));
	assertEquals(true, printer.toString().contains("Print technology: Inkjet printing"));
	assertEquals(true, printer.toString().contains("number of colors: 4"));
	assertEquals(true, printer.toString().contains("weight: 2,3"));
	assertEquals(true, printer.toString().contains("Price: 300"));
	

    }

}
