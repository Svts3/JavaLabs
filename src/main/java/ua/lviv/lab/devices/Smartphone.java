package ua.lviv.lab.devices;

public class Smartphone extends Device {
    private String cpu;
    private String videoCore;
    private int ram;
    private int memory;
    private double screenDiagonal;
    private int batteryCapacityInMa;
    private int numberOfFrontCameras;

    public Smartphone(final String brand, final String model, final int priceInUah,
	    	final double weightInKg, String cpu, final String videoCore, final int ram,
	    	final int memory, final double screenDiagonal, final int batteryCapacityInMa,
	    	final int numberOfFrontCameras) {
	super(brand, model, priceInUah, weightInKg);
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
		"CPU: %s, video core: %s\n" + "RAM: %d, memory: %d Gb\n"
			+ "Screen diagonal: %.1f\", number of front cameras: %d\n"
			+ "Battery capacity: %d Ma\n",
		cpu, videoCore, ram, memory, screenDiagonal, numberOfFrontCameras,
		batteryCapacityInMa);
    }

    public String getHeaders() {
	return super.getHeaders() + "CPU;Video core;RAM;Memory;Battery Capacity;Screen Diagonal;"
				+ "Number of Front Cameras;";
    }

    public String toCSV() {
	return super.toCSV() + String.format("%s;%s;%d;%d;%d;%.1f;%d", this.cpu, this.videoCore,
                        		this.ram, this.memory, this.batteryCapacityInMa,
                        		this.screenDiagonal, this.numberOfFrontCameras);
    }

}
