package ua.lviv.lab.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import ua.lviv.lab.controller.DeviceController;

@Component
public class JerseyConfig extends ResourceConfig {

        public JerseyConfig(Class<?>... classes) {
            register(DeviceController.class);
    }
}
