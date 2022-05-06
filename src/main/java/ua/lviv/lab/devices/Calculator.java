package ua.lviv.lab.devices;

public class Calculator extends Device {
    private int dimension;

    public Calculator(String brand, String model, int priceInUsd,double weightInKg,
                      int dimension) {
        super(brand, model, priceInUsd, weightInKg);
        super.setTypeOfDevice(Type.CALCULATOR);
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Dimension: %d\n", dimension);
    }

    public String getHeaders() {
        return super.getHeaders() + "Dimension;";
    }

    public String toCSV() {
        return super.toCSV() + this.dimension + ";";
    }

}
