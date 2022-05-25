package ua.lviv.lab.devices;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Device {

    private String brand;
    private String model;
    private int priceInUsd;
    private double weightInKg;
    @Enumerated(EnumType.STRING)
    private Type typeOfDevice;

    public Device(String brand, String model, int priceInUsd, double weightInKg) {

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

    @JsonIgnore
    public String getHeaders() {
        return "Brand;Model;Price;Weight;Type;";
    }

    public String toCSV() {

        return String.format("%s;%s;%d;%.1f;%s;", this.brand, this.model, this.priceInUsd,
                this.weightInKg, this.typeOfDevice.name());
    }

}
