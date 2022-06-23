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

    public Map<Integer, Laptop> addDevices(List<Laptop> devices) {
        return repository.saveAll(devices).stream()
                .collect(Collectors.toMap(Laptop::getId, device -> device));
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
            Laptop laptop2 = repository.findById(id).get();
            laptop2.setId(id);
            laptop2.setBrand(laptop.getBrand());
            laptop2.setModel(laptop.getModel());
            laptop2.setPriceInUsd(laptop.getPriceInUsd());
            laptop2.setScreenDiagonal(laptop.getScreenDiagonal());
            laptop2.setBatteryCapacityInW(laptop.getBatteryCapacityInW());
            laptop2.setTypeOfDevice(laptop.getTypeOfDevice());
            laptop2.setWeightInKg(laptop.getWeightInKg());
            laptop2.setCpu(laptop.getCpu());
            laptop2.setGpu(laptop.getGpu());
            laptop2.setRam(laptop.getRam());
            laptop2.setMemoryInGb(laptop.getMemoryInGb());
            return new ResponseEntity<Object>(repository.save(laptop2), HttpStatus.OK);

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
