package ua.lviv.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import ua.lviv.lab.devices.Laptop;
import ua.lviv.lab.repository.DeviceRepository;

@Service
public class DeviceService {

    public DeviceRepository repository;
    @Autowired
    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public Laptop addDevice(Laptop Laptop) {
        return repository.save(Laptop);
    }

    public List<Laptop> addDevices(List<Laptop> devices) {
        return repository.saveAll(devices);
    }

    public String removeDevice(int id) {
        repository.deleteById(id);
        return "Laptop with id " + id + " was deleted!";
    }

    @Modifying
    public Laptop updateDevice(Laptop laptop, int id) {
        Laptop tempLaptop = repository.findById(id).get();
        tempLaptop.setId(id);
        tempLaptop.setBrand(laptop.getBrand());
        tempLaptop.setModel(laptop.getModel());
        tempLaptop.setPriceInUsd(laptop.getPriceInUsd());
        tempLaptop.setScreenDiagonal(laptop.getScreenDiagonal());
        tempLaptop.setBatteryCapacityInW(laptop.getBatteryCapacityInW());
        tempLaptop.setTypeOfDevice(laptop.getTypeOfDevice());
        tempLaptop.setWeightInKg(laptop.getWeightInKg());
        return repository.save(tempLaptop);
    }

    public List<Laptop> findAllDevices() {
        return repository.findAll();
    }

    public Laptop findById(int id) {
        return repository.findById(id).orElse(null);
    }

}
