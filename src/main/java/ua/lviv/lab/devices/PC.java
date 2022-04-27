package ua.lviv.lab.devices;

public class PC extends Device {

    private String cpu;
    private String gpu;
    private int ram;
    private int memoryInGb;

    public PC(final String brand, final String model, final int priceInUsd, final double weightInKg,
	    final String cpu, final String gpu, final int ram, final int memoryInGb) {
	super(brand, model, priceInUsd, weightInKg);
	super.setTypeOfDevice(Type.PC);
	this.cpu = cpu;
	this.gpu = gpu;
	this.ram = ram;
	this.memoryInGb = memoryInGb;

    }

    @Override
    public String toString() {
	return super.toString() + String.format("CPU: %s, GPU: %s\n" + "RAM: %d, Memory: %d Gb\n",
		cpu, gpu, ram, memoryInGb);
    }

    public String getHeaders() {
	return super.getHeaders() + "CPU;GPU;RAM;Memory;";
    }

    public String toCSV() {
	return super.toCSV() + this.cpu + ";" + this.gpu + ";" + this.ram + ";" + memoryInGb + ";";
    }

}
