package ua.lviv.lab.devices;

import ua.lviv.lab.enums.Type;

public class Laptop extends PC{

    private double batteryCapacityInW;
    public double screenDiagonal;
    public Laptop(String brand, String model, int priceInUsd,
	    double weigth, String cpu, String gpu,
	    int ram,int memoryInGb,double batteryCapacityInMa,
	    double screenDiagonal) {
	
	super(brand, model, priceInUsd, weigth, cpu, gpu, ram,memoryInGb);
	super.setTypeOfDevice(Type.LAPTOP);
	this.batteryCapacityInW = batteryCapacityInMa;
	this.screenDiagonal = screenDiagonal;
    }
    @Override
    public String toString() {
	return super.toString()+String.format("Battery capacity: %.1f W,"
						+ "Screen diagonal: %.1f\"",
						batteryCapacityInW,screenDiagonal);
    }

}
