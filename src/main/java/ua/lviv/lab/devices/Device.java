package ua.lviv.lab.devices;

public abstract class Device {

    private String brand;
    private String model;
    private int priceInUsd;
    private double weightInKg;
    private Type typeOfDevice;

    public Device(final String brand, final String model, final int priceInUsd,
	    	final double weightInKg) {

	this.brand = brand;
	this.model = model;
	this.priceInUsd = priceInUsd;
	this.weightInKg = weightInKg;

    }

    @Override
    public String toString() {
	return String.format("Brand: %s, model: %s\n" + "Price: %d $, weight: %.1f Kg\n", brand,
		model, priceInUsd, weightInKg);
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

    public double getWeightInKg() {
	return weightInKg;
    }

    public String getHeaders() {
	return "Brand;Model;Price;Weight;Type;";
    }

    public String toCSV() {

	return String.format("%s;%s;%d;%.1f;%s;", this.brand, this.model, this.priceInUsd,
		this.weightInKg, this.typeOfDevice.name());
    }

}
