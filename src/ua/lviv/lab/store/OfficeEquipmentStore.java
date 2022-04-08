package ua.lviv.lab.store;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lab.enums.Type;

import ua.lviv.lab.devices.*;

public class OfficeEquipmentStore {
    
    private List<Device>devices = new ArrayList<>();
    
    public OfficeEquipmentStore() {}

    public OfficeEquipmentStore(List<Device> devices) {
	super();
	this.devices = devices;
    }
    public void addDevice(Device device) {
	devices.add(device);
    }
    
    public Device findDeviceByTypeInRange(Type type,int minPrice,int maxPrice) {
	return null;
    }
    public List<Device> sortDevicesByPrice(){
	return null;
    }
    public List<Device> sortDevicesByWeigth(){
	return null;
    }
    
    
    
    
   

}
