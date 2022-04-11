package ua.lviv.lab.devices;

public class Printer extends Device{
    private String printTechnology;
    private int numberOfColors;
    
    public Printer(String brand, String model, int priceInUah,
	    	double weightInKg, String printTechnology,int numberOfColors) {
	super(brand, model, priceInUah, weightInKg);
	super.setTypeOfDevice(Type.PRINTER);
	this.printTechnology = printTechnology;
	this.numberOfColors = numberOfColors;
    }
    @Override
    public String toString() {
	return super.toString()+String.format("Print technology: %s,"
					+ "number of colors: %d\n"
					, printTechnology,numberOfColors);
    }
    

}
