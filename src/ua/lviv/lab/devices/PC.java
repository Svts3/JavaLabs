package ua.lviv.lab.devices;

import ua.lviv.lab.enums.Type;

public class PC extends Device{
    
    private String cpu;
    private String gpu;
    private int ram;
    private int memoryInGb;
    public PC(String brand,String model,int priceInUsd,
	    double weigth,String cpu,
	    String gpu,int ram,int memoryInGb) {
	super(brand,model,priceInUsd,weigth);
	super.setTypeOfDevice(Type.PC);
	this.cpu = cpu;
	this.gpu = gpu;
	this.ram = ram;
	this.memoryInGb = memoryInGb;
	
    }
    @Override
    public String toString() {
	return super.toString()+String.format("Cpu: %s, Gpu: %s\n"
			+ "Ram: %d, Memory: %d Gb\n",
			cpu,gpu,ram,memoryInGb);
    }
    

}
