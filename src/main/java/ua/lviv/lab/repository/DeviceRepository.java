package ua.lviv.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lab.devices.Laptop;
public interface DeviceRepository extends JpaRepository<Laptop, Integer>{

}
