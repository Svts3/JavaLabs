package ua.lviv.lab.store;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.lab.devices.*;

public class OfficeEquipmentStore {

    private List<Device> devices = new ArrayList<>();
    private List<Device> foundedDevices;

    public OfficeEquipmentStore() {
    }

    public OfficeEquipmentStore(List<Device> devices) {
	this.devices = devices;
    }

    public void addDevice(Device device) {
	devices.add(device);
    }

    public List<Device> getDevices() {
	return devices;
    }

    public List<Device> findDevicesByTypeInRange(Type type, int minPrice, int maxPrice)
	    throws Exception {
	if (minPrice > maxPrice)
	    throw new Exception("Error! Minimal price is bigger than maximal price.");
	foundedDevices = devices.stream().filter(device -> device.getTypeOfDevice().equals(type))
		.filter(device -> device.getPriceInUsd() >= minPrice)
		.filter(device -> device.getPriceInUsd() <= maxPrice).collect(Collectors.toList());
	System.out.println("Founded devices:\n");
	for (Device device : foundedDevices) {
	    System.out.println(device);
	}

	return foundedDevices;
    }

    public List<Device> sortFoundedDevicesByPrice(boolean reversed){
	if (reversed) {
	    foundedDevices = foundedDevices.stream()
		    .sorted(Comparator.comparing(Device::getPriceInUsd).reversed())
		    .collect(Collectors.toList());
	    System.out.println("Sorted by price(Reversed):\n");
	} else {
	    foundedDevices = foundedDevices.stream()
		    .sorted(Comparator.comparing(Device::getPriceInUsd))
		    .collect(Collectors.toList());
	    System.out.println("Sorted by price: \n");
	}
	for (Device device : foundedDevices) {
	    System.out.println(device);
	}

	return foundedDevices;
    }

    public List<Device> sortFoundedDevicesByWeigth(boolean reversed) {
	if (reversed) {
	    foundedDevices = foundedDevices.stream()
		    .sorted(Comparator.comparing(Device::getWeightInKg).reversed())
		    .collect(Collectors.toList());
	    System.out.println("Sorted by price(Reversed):\n");
	} else {
	    foundedDevices = foundedDevices.stream()
		    .sorted(Comparator.comparing(Device::getWeightInKg))
		    .collect(Collectors.toList());
	    System.out.println("Sorted by price:\n");
	}
	for (Device device : foundedDevices) {
	    System.out.println(device);
	}
	return foundedDevices;
    }

}
