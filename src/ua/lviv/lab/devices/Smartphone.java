package ua.lviv.lab.devices;

import ua.lviv.lab.enums.Type;

public class Smartphone extends Device {
    private String cpu;
    private String videoCore;
    private int ram;
    private int memory;
    private double screenDiagonal;
    private int batteryCapacityInMa;
    private int numberOfFrontCameras;

    public Smartphone(String brand, String model, int priceInUah,
	    double weigthInKg, String cpu, String videoCore,
	    int ram, int memory, double screenDiagonal,
	    int batteryCapacityInMa, int numberOfFrontCameras) {
	super(brand, model, priceInUah, weigthInKg);
	super.setTypeOfDevice(Type.SMARTPHONE);
	this.cpu = cpu;
	this.videoCore = videoCore;
	this.ram = ram;
	this.memory = memory;
	this.screenDiagonal = screenDiagonal;
	this.batteryCapacityInMa = batteryCapacityInMa;
	this.numberOfFrontCameras = numberOfFrontCameras;
    }

    @Override
    public String toString() {
	return super.toString() + String.format(
		"CPU: %s, video core: %s\n" + "Ram: %d, memory: %d Gb\n"
		+ "Screen diagonal: %.1f\", number of front cameras: %d\n"
		+ "Battery capacity: %d Ma",
		cpu, videoCore, ram, memory,
		screenDiagonal, numberOfFrontCameras, batteryCapacityInMa);
    }

}