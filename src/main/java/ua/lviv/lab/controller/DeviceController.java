package ua.lviv.lab.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.lab.devices.Laptop;
import ua.lviv.lab.service.DeviceService;

@RestController
@Consumes("application/json")
@Produces("application/json")
@Path("/laptop")
public class DeviceController {

    
    public DeviceService service;
    @Autowired
    public DeviceController(DeviceService service) {
        this.service = service;
    }
    @GET
    @Path("/test")
    public Laptop test() {
        return new Laptop("Lenovo", "Legion", 0, 0, null, null, 0, 0, 0, 0);
    }
    @GET
    @Path("/{id}")
    public Laptop findDeviceById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @Path("/")
    public List<Laptop> findAllDevices() {
        return service.findAllDevices();
    }

    @POST
    @Path("/")
    public Laptop addDevice(Laptop Laptop) {
        return service.addDevice(Laptop);
    }
    @POST
    @Path("/laptops")
    public List<Laptop> addDevices(List<Laptop> devices) {
        return service.addDevices(devices);
    }
    @PUT
    @Path("/{id}")
    public Laptop updateDevice(Laptop Laptop, @PathParam("id") int id) {
        return service.updateDevice(Laptop, id);
    }
    @DELETE
    @Path("/{id}")
    public String deleteDevice(@PathParam("id") int id) {
        service.removeDevice(id);
        return "Laptop with id " + id + " was removed!";
    }

}
