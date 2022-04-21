package ua.lviv.lab.store;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.lab.devices.Calculator;
import ua.lviv.lab.devices.Device;
import ua.lviv.lab.devices.Laptop;
import ua.lviv.lab.devices.PC;
import ua.lviv.lab.devices.Type;

class TestOfficeEquipmentStore {
    private OfficeEquipmentStore testOfficeEquipmentStore;

    @BeforeEach
    public void addDevices() {
	this.testOfficeEquipmentStore = new OfficeEquipmentStore();
	testOfficeEquipmentStore.addDevice(new Laptop("HP", "Omen", 1400, 2.4, "R5 5600",
					"Rtx 3050", 16, 512, 72, 17));
	testOfficeEquipmentStore.addDevice(new Laptop("Asus", "VivoBook", 1700, 3, "R5 5600",
					"Rtx 3050", 16, 512, 72, 17));
	testOfficeEquipmentStore.addDevice(new Laptop("Dell", "XPS", 1650, 2.7, "R5 5600",
					"Rtx 3050", 16, 512, 72, 17));
	testOfficeEquipmentStore.addDevice(new PC("Asus", "S-500", 1500, 3.4, "R5 5600x",
					"RTX 3060", 16, 1000));

    }

    @Test
    void testConstructorThatGetsList() {
	Calculator calculator = new Calculator("Casio", "212", 5, 0.5, 12);
	Laptop laptop = new Laptop("Lenovo", "Legion", 1400, 2.4, "R5 5600", "Rtx 3050", 16, 512,
				72, 17);
	List<Device> tempList = new ArrayList<>();
	tempList.add(calculator);
	tempList.add(laptop);
	OfficeEquipmentStore officeEquipmentStore = new OfficeEquipmentStore(tempList);
	assertEquals(2, officeEquipmentStore.getDevices().size());
	assertEquals("Casio", officeEquipmentStore.getDevices().get(0).getBrand());
	assertEquals("212", officeEquipmentStore.getDevices().get(0).getModel());
	assertEquals("Legion", officeEquipmentStore.getDevices().get(1).getModel());
	assertEquals("Lenovo", officeEquipmentStore.getDevices().get(1).getBrand());
	OfficeEquipmentStore officeEquipmentStore2 = new OfficeEquipmentStore(new ArrayList<Device>());
	assertEquals(0, officeEquipmentStore2.getDevices().size());

    }

    @Test
    void testAddDevice() {
	assertEquals(4, testOfficeEquipmentStore.getDevices().size());
	testOfficeEquipmentStore.addDevice(new Calculator("Casio", "212", 5, 0.5, 12));
	testOfficeEquipmentStore.addDevice(new Laptop("Lenovo", "Legion", 1400, 2.4, "R5 5600",
		"Rtx 3050", 16, 512, 72, 17));

	assertEquals(6, testOfficeEquipmentStore.getDevices().size());
	assertEquals("Omen", testOfficeEquipmentStore.getDevices().get(0).getModel());
	assertEquals("Asus", testOfficeEquipmentStore.getDevices().get(1).getBrand());

    }

    @Test
    void testFindByTypeInRange() throws Exception {

	assertEquals("HP", testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0, 1700)
		.get(0).getBrand());
	assertEquals("Asus", testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0, 1700)
		.get(1).getBrand());
	assertEquals("Dell", testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0, 1700)
		.get(2).getBrand());
	assertEquals("Asus", testOfficeEquipmentStore.findDevicesByTypeInRange(Type.PC, 1500, 1500)
		.get(0).getBrand());
	assertThrows(IllegalArgumentException.class, ()->{
	    testOfficeEquipmentStore.findDevicesByTypeInRange(null, 0, 0);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    testOfficeEquipmentStore.findDevicesByTypeInRange(Type.PC, 3000, 0);
	});
    }

    @Test
    void testSortFoundedDevicesByPriceASC() throws Exception {

	List<Device> tempList = testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0,
		1700);
	tempList = testOfficeEquipmentStore.sortFoundedDevicesByPrice(false);
	assertEquals(3, tempList.size());
	assertEquals("HP", tempList.get(0).getBrand());
	assertEquals("Dell", tempList.get(1).getBrand());
	assertEquals("Asus", tempList.get(2).getBrand());

	assertEquals(1400, tempList.get(0).getPriceInUsd());
	assertEquals(1650, tempList.get(1).getPriceInUsd());
	assertEquals(1700, tempList.get(2).getPriceInUsd());


    }

    @Test
    void testSortFoundedDevicesByPriceDESC() throws Exception{

	List<Device> tempList = testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0,
		1700);
	tempList = testOfficeEquipmentStore.sortFoundedDevicesByPrice(true);
	assertEquals(3, tempList.size());
	assertEquals("Asus", tempList.get(0).getBrand());
	assertEquals("Dell", tempList.get(1).getBrand());
	assertEquals("HP", tempList.get(2).getBrand());

	assertEquals(1700, tempList.get(0).getPriceInUsd());
	assertEquals(1650, tempList.get(1).getPriceInUsd());
	assertEquals(1400, tempList.get(2).getPriceInUsd());
    }

    @Test
    void testSortFoundedDevicesByWeightASC() throws Exception{

	List<Device> tempList = testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0,
										1700);
	tempList = testOfficeEquipmentStore.sortFoundedDevicesByWeigth(false);
	assertEquals(3, tempList.size());
	assertEquals("HP", tempList.get(0).getBrand());
	assertEquals("Dell", tempList.get(1).getBrand());
	assertEquals("Asus", tempList.get(2).getBrand());

	assertEquals(2.4, tempList.get(0).getWeightInKg());
	assertEquals(2.7, tempList.get(1).getWeightInKg());
	assertEquals(3, tempList.get(2).getWeightInKg());



    }

    @Test
    void testSortFoundedDevicesByWeightDESC() throws Exception {

	List<Device> tempList = testOfficeEquipmentStore.findDevicesByTypeInRange(Type.LAPTOP, 0,
										1700);
	tempList = testOfficeEquipmentStore.sortFoundedDevicesByWeigth(true);
	assertEquals(3, tempList.size());
	assertEquals("Asus", tempList.get(0).getBrand());
	assertEquals("Dell", tempList.get(1).getBrand());
	assertEquals("HP", tempList.get(2).getBrand());

	assertEquals(3, tempList.get(0).getWeightInKg());
	assertEquals(2.7, tempList.get(1).getWeightInKg());
	assertEquals(2.4, tempList.get(2).getWeightInKg());



    }

}
