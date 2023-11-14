package edu.francistuttle;

import java.util.ArrayList;

public class Computer {
    String id;
    String manufacturer;
    String processor;
    ArrayList<Monitor> monitors = new ArrayList<Monitor>();

    public Computer(String inputId, String inputManufacturer, String inputProcessor, ArrayList<Monitor> inputMonitors) {
        id = inputId;
        manufacturer = inputManufacturer;
        processor = inputProcessor;
        monitors = inputMonitors;
    }
}
