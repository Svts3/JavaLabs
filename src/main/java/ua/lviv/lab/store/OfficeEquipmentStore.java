package ua.lviv.lab.store;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.lab.devices.*;

public class OfficeEquipmentStore {
    
    private List<Device>devices = new ArrayList<>();
    private List<Device>foundedDevices;
    public OfficeEquipmentStore() {}

    public OfficeEquipmentStore(List<Device> devices) {
	this.devices = devices;
    }
    public void addDevice(Device device) {
	devices.add(device);
    }
    
    public List<Device> findDevicesByTypeInRange(Type type,int minPrice,int maxPrice) {
	foundedDevices = devices.stream()
	.filter(device->device.getTypeOfDevice().equals(type))
	.filter(device->device.getPriceInUsd()>=minPrice)
	.filter(device->device.getPriceInUsd()<=maxPrice)
	.collect(Collectors.toList());
	return foundedDevices;
    }
    public List<Device> sortFoundedDevicesByPrice(boolean reversed){
	if(reversed) {
	    foundedDevices = foundedDevices.stream()
		    .sorted(Comparator.comparing(Device::getPriceInUsd).reversed())
		    .collect(Collectors.toList());
	
	}else {
	    foundedDevices = foundedDevices.stream()
			.sorted(Comparator.comparing(Device::getPriceInUsd))
			.collect(Collectors.toList());
	}
	
	
	return foundedDevices;
    }
    public List<Device> sortFoundedDevicesByWeigth(boolean reversed){
	if(reversed) {
	foundedDevices = foundedDevices.stream()
	.sorted(Comparator.comparing(Device::getWeightInKg).reversed())
	.collect(Collectors.toList());
	}
	else {
	    foundedDevices = foundedDevices.stream()
		.sorted(Comparator.comparing(Device::getWeightInKg))
		.collect(Collectors.toList());
	}
	return foundedDevices;
    }
    
    
    
    
   

}
