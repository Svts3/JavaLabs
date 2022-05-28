package ua.lviv.lab.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ua.lviv.lab.devices.Laptop;
import ua.lviv.lab.exceptions.DeviceNotFoundException;
import ua.lviv.lab.repository.DeviceRepository;

@Service
public class DeviceService {

    public DeviceRepository repository;

    @Autowired
    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public Laptop addDevice(Laptop laptop) {
        return repository.save(laptop);
    }

    public List<Laptop> addDevices(List<Laptop> devices) {
        return repository.saveAll(devices);
    }

    public ResponseEntity<Object> removeDevice(int id) {

        if (repository.findById(id).isEmpty()) {
            return new ResponseEntity<Object>(
                    new DeviceNotFoundException("Device with id " + id + " wasn't found!")
                            .getMessage(), HttpStatus.NOT_FOUND);
        } else {
            Laptop laptop = repository.findById(id).get();
            repository.deleteById(id);
            return new ResponseEntity<Object>(laptop, HttpStatus.OK);
        }
    }

    @Modifying
    public ResponseEntity<Object> updateDevice(Laptop laptop, int id) {
        if (repository.findById(id).isEmpty()) {
            return new ResponseEntity<Object>(
                    new DeviceNotFoundException("Device with id " + id + " wasn't found!")
                            .getMessage(), HttpStatus.NOT_FOUND);
        } else {
            Laptop tempLaptop = repository.findById(id).get();
            tempLaptop.setId(id);
            tempLaptop.setBrand(laptop.getBrand());
            tempLaptop.setModel(laptop.getModel());
            tempLaptop.setPriceInUsd(laptop.getPriceInUsd());
            tempLaptop.setScreenDiagonal(laptop.getScreenDiagonal());
            tempLaptop.setBatteryCapacityInW(laptop.getBatteryCapacityInW());
            tempLaptop.setTypeOfDevice(laptop.getTypeOfDevice());
            tempLaptop.setWeightInKg(laptop.getWeightInKg());
            tempLaptop.setCpu(laptop.getCpu());
            tempLaptop.setGpu(laptop.getGpu());
            tempLaptop.setRam(laptop.getRam());
            tempLaptop.setMemoryInGb(laptop.getMemoryInGb());
            return new ResponseEntity<Object>(repository.save(tempLaptop), HttpStatus.OK);

        }
    }

    public Map<Integer, Laptop> findAllDevices() {
        return repository.findAll().stream().collect(Collectors.toMap(Laptop::getId, t -> t));
    }

    public ResponseEntity<Object> findById(int id) {
        if (repository.findById(id).isEmpty()) {
            return new ResponseEntity<Object>(
                    new DeviceNotFoundException("Device with id " + id + " wasn't found!")
                            .getMessage(), HttpStatus.NOT_FOUND);
        } else {
            Laptop laptop = repository.findById(id).get();
            return new ResponseEntity<Object>(laptop, HttpStatus.OK);
        }
    }

}
