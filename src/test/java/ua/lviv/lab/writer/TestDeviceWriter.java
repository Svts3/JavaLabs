package ua.lviv.lab.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.lab.devices.Calculator;
import ua.lviv.lab.devices.Laptop;
import ua.lviv.lab.devices.PC;
import ua.lviv.lab.devices.Printer;
import ua.lviv.lab.devices.Smartphone;
import ua.lviv.lab.store.OfficeEquipmentStore;

class TestDeviceWriter {

    private OfficeEquipmentStore testOfficeEquipmentStore;

    @Test
    void testWriteToFile() {
	this.testOfficeEquipmentStore = new OfficeEquipmentStore();
	testOfficeEquipmentStore.addDevice(new Laptop("HP", "Omen", 1400, 2.4, "R5 5600",
					"Rtx 3050", 16, 512, 72, 17));
	testOfficeEquipmentStore.addDevice(new Laptop("Asus", "VivoBook", 1700, 3, "R5 5600",
					"Rtx 3050", 16, 512, 72, 17));
	testOfficeEquipmentStore.addDevice(new Laptop("Dell", "XPS", 1650, 2.7, "R5 5600",
					"Rtx 3050", 16, 512, 72, 17));
	testOfficeEquipmentStore.addDevice(new PC("Asus", "S-500", 1500, 3.4, "R5 5600x",
					"RTX 3060", 16, 1000));
	testOfficeEquipmentStore.addDevice(new Calculator("Casio", "212", 10, 0.4, 12));
	testOfficeEquipmentStore.addDevice(new Smartphone("Apple", "Iphone 13", 1700, 0.7,
					"A15 Bionic", "A15 Bionic", 8, 512, 8.6, 4000, 3));
	testOfficeEquipmentStore.addDevice(new Printer("Canon", "xm-12", 250, 2.5, "Lazer", 3));
	
	DeviceWriter deviceWriter = new DeviceWriter();
	deviceWriter.writeToFile("result", testOfficeEquipmentStore.getDevices());
	
	Path expectedPath = Paths.get("src\\test\\java\\resources\\expected.csv");
	Path resultReader = Paths.get("result.csv");
	
	List<String> expectedLines = new ArrayList<>();
	List<String> resultLines = new ArrayList<>();
	try {
	    expectedLines = Files.readAllLines(expectedPath);
	    resultLines = Files.readAllLines(resultReader);
	}catch(IOException e) {
	    e.printStackTrace();
	}
	assertEquals(expectedLines, resultLines);
	}

	@Test
	void testWriteToFileThatGetsEmptyList() {
	    DeviceWriter deviceWriter = new DeviceWriter();
	    OfficeEquipmentStore equipmentStore = new OfficeEquipmentStore();
	    deviceWriter.writeToFile("result2", equipmentStore.getDevices());

	    Path expectedPath = Paths.get("src\\test\\java\\resources\\expected2.csv");
	    Path resultReader = Paths.get("result2.csv");

	    List<String> expectedLines = new ArrayList<>();
	    List<String> resultLines = new ArrayList<>();
	    try {
		expectedLines = Files.readAllLines(expectedPath);
		resultLines = Files.readAllLines(resultReader);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    assertEquals(expectedLines, resultLines);
	    assertEquals(true, expectedLines.size() == 0 && resultLines.size() == 0);

    }

    @Test
    void testWriteToFileThatGetsListOfLaptops() {

	DeviceWriter deviceWriter = new DeviceWriter();
	OfficeEquipmentStore equipmentStore = new OfficeEquipmentStore();
	equipmentStore.addDevice(
		new Laptop("HP", "Omen", 1400, 2.4, "R5 5600", "Rtx 3050", 16, 512, 72, 17));
	equipmentStore.addDevice(
		new Laptop("Asus", "VivoBook", 1700, 3, "R5 5600", "Rtx 3050", 16, 512, 72, 17));
	equipmentStore.addDevice(
		new Laptop("Dell", "XPS", 1650, 2.7, "R5 5600", "Rtx 3050", 16, 512, 72, 17));
	deviceWriter.writeToFile("result3", equipmentStore.getDevices());


	Path expectedPath = Paths.get("src\\test\\java\\resources\\expected3.csv");
	Path resultReader = Paths.get("result3.csv");

	List<String> expectedLines = new ArrayList<>();
	List<String> resultLines = new ArrayList<>();
	try {
	    expectedLines = Files.readAllLines(expectedPath);
	    resultLines = Files.readAllLines(resultReader);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	assertEquals(expectedLines, resultLines);

    }

}
