package ua.lviv.lab.devices;
import ua.lviv.lab.enums.Type;
public abstract class Device {
    
    private String brand;
    private String model;
    private int priceInUsd;
    private double weigthInKg;
    public Type typeOfDevice;
    
    public Device(String brand,String model,int priceInUah,double weigth) {
	
	this.brand = brand;
	this.model = model;
	this.priceInUsd = priceInUah;
	this.weigthInKg = weigth;
	
    }
    @Override
    public String toString() {
	return String.format("Brand: %s, model: %s\n"+
			"Price: %d $, weigth: %.1f Kg\n",
			brand,model,priceInUsd,weigthInKg);
    }
    
    public Type getTypeOfDevice() {
        return typeOfDevice;
    }

    public void setTypeOfDevice(Type typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPriceInUsd() {
        return priceInUsd;
    }

    public double getWeigthInKg() {
        return weigthInKg;
    }

    
    
    
    

}
