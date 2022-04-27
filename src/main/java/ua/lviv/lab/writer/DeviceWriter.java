package ua.lviv.lab.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ua.lviv.lab.devices.Device;

public class DeviceWriter {

    public void writeToFile(final String fileName, final List<Device> devices) {
	try (FileWriter writer = new FileWriter(fileName + ".csv")) {
	    String previousClassName = "";
	    for (Device device : devices) {
		if (!device.getClass().getSimpleName().equals(previousClassName)) {
		    writer.write(device.getHeaders());
		    writer.write("\r\n");
		    previousClassName = device.getClass().getSimpleName();
		}
		writer.write(device.toCSV());
		writer.write("\r\n");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
