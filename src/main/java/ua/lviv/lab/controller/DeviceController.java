package ua.lviv.lab.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.lab.devices.Laptop;
import ua.lviv.lab.service.DeviceService;

@RestController
@ComponentScan("ua.lviv.lab")
@RequestMapping("/laptop")
public class DeviceController {

    
    public DeviceService service;
    @Autowired
    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public Laptop test() {
        return new Laptop("Lenovo", "Legion", 0, 0, null, null, 0, 0, 0, 0);
    }

    @GetMapping("/{id}")
    public Laptop findDeviceById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/")
    public List<Laptop> findAllDevices() {
        return service.findAllDevices();
    }

    @PostMapping("/")
    @ResponseBody
    public Laptop addDevice(@RequestBody Laptop Laptop) {
        return service.addDevice(Laptop);
    }

    @PostMapping("/laptops")
    public List<Laptop> addDevices(@RequestBody List<Laptop> devices) {
        return service.addDevices(devices);
    }

    @PutMapping("/{id}")
    public Laptop updateDevice(@RequestBody Laptop Laptop, @PathVariable int id) {
        return service.updateDevice(Laptop, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDevice(@PathVariable int id) {
        service.removeDevice(id);
        return "Laptop with id " + id + " was removed!";
    }

}
