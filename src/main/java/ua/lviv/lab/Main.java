package ua.lviv.lab;

import java.util.List;

import ua.lviv.lab.devices.*;
import ua.lviv.lab.store.OfficeEquipmentStore;

public class Main {

    public static void main(String[] args) {

	Device laptop = new Laptop("Lenovo", "legion", 2000, 2.9, "Ryzen 7 5600h",
				"RTX 3060", 16, 512, 72, 17);
	Device laptop2 = new Laptop("Asus", "Zephyrus", 2200, 2.7, "Ryzen 7 5600h",
				"RTX 3070", 16, 1000, 72, 15);
	Device laptop3 = new Laptop("Apple", "Macbook", 1300, 1.9, "M1", "M1 gpu",
				16, 1000, 72, 13);
	Device laptop4 = new Laptop("Razer", "Blade", 2100, 2.4, "I5-10700f", "gtx 3060",
				16, 1000, 72, 15);

	Device smartphone = new Smartphone("Apple", "Iphone 13", 1700, 0.7, "A15 Bionic",
				"A15 Bionic", 8, 512, 8.6,4000, 3);
	Device pc = new PC("Lenovo", "Tower", 2100, 5.7, "R5 5600x", "RTX 3060", 16,
			1000);
	Device printer = new Printer("HP", "LaserJet", 700, 5.5, "lazer", 1);
	Device calculator = new Calculator("Casio", "HL-815L", 10, 0.5, 12);

	OfficeEquipmentStore store = new OfficeEquipmentStore();

	store.addDevice(laptop);
	store.addDevice(laptop2);
	store.addDevice(laptop3);
	store.addDevice(laptop4);
	store.addDevice(calculator);
	store.addDevice(printer);
	store.addDevice(smartphone);
	store.addDevice(pc);
	
	List<Device> devices = store.findDevicesByTypeInRange(Type.LAPTOP, 0, 2300);
	System.out.println("Sorted by price: ");
	devices = store.sortFoundedDevicesByPrice(false);
	for (Device device : devices) {
	    System.out.println(device);
	}
	System.out.println("Sorted by price(Reversed): ");
	devices = store.sortFoundedDevicesByPrice(true);
	for (Device device : devices) {
	    System.out.println(device);
	}
	System.out.println("Sorted by weigth: ");
	devices = store.sortFoundedDevicesByWeigth(false);
	for (Device device : devices) {
	    System.out.println(device);
	}
	System.out.println("Sorted by weigth(Reversed): ");
	devices = store.sortFoundedDevicesByWeigth(true);
	for (Device device : devices) {
	    System.out.println(device);
	}

    }

}
