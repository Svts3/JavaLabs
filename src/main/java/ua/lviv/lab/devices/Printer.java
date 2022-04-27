package ua.lviv.lab.devices;

public class Printer extends Device {
    private String printTechnology;
    private int numberOfColors;

    public Printer(final String brand, final String model, final int priceInUah,
	    	final double weightInKg, final String printTechnology, final int numberOfColors) {
	super(brand, model, priceInUah, weightInKg);
	super.setTypeOfDevice(Type.PRINTER);
	this.printTechnology = printTechnology;
	this.numberOfColors = numberOfColors;
    }

    @Override
    public String toString() {
	return super.toString() + String.format("Print technology: %s," + "number of colors: %d\n",
		printTechnology, numberOfColors);
    }

    public String getHeaders() {
	return super.getHeaders() + "Print Technology;Number of colors";
    }

    public String toCSV() {
	return super.toCSV() + this.printTechnology + ";" + this.numberOfColors;
    }

}
