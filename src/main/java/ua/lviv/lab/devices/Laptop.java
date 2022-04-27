package ua.lviv.lab.devices;

public class Laptop extends PC {

    private double batteryCapacityInW;
    private double screenDiagonal;

    public Laptop(final String brand, final String model, final int priceInUsd,
	    	final double weightInKg, String cpu, final String gpu, final int ram,
	    	final int memoryInGb, final double batteryCapacityInMa,
	    	final double screenDiagonal){

	super(brand, model, priceInUsd, weightInKg, cpu, gpu, ram, memoryInGb);
	super.setTypeOfDevice(Type.LAPTOP);
	this.batteryCapacityInW = batteryCapacityInMa;
	this.screenDiagonal = screenDiagonal;
    }

    @Override
    public String toString() {
	return super.toString()
		+ String.format("Battery capacity: %.1f W," + "Screen diagonal: %.1f\"\n",
			batteryCapacityInW, screenDiagonal);
    }

    public String getHeaders() {
	return super.getHeaders() + "Battery Capacity;Screen Diagonal;";
    }

    public String toCSV() {
	return super.toCSV()
		+ String.format("%.1f;%.1f", this.batteryCapacityInW, this.screenDiagonal);
    }

}
