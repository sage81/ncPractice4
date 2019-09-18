package com.netcracker.edu.inventory;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;
import com.netcracker.edu.inventory.model.impl.*;
import com.netcracker.edu.inventory.service.impl.ServiceImpl;

public class Main {

    public static void main(String[] args) {
        DeviceValidationException v = new DeviceValidationException(null);
    }

    private static void showRack(Rack rack) {
        for (int i = 0; i < rack.getSize(); i++) {
            if (rack.getDevAtSlot(i) != null) {
                System.out.println("slot"+ i + " | " + rack.getDevAtSlot(i));
            } else {
                System.out.println("slot"+ i + " | empty" );
            }
        }
    }

    private static void fillRack(Device[] devices, Rack rack) {
        for (int i = 0; i < devices.length; i++) {
            rack.insertDevToSlot(devices[i], i);
        }
    }

    private static void showDevArray(Device[] devices) {
        for (int i = 0; i < devices.length; i++) {
            if (devices[i] != null) {
                System.out.println("slot"+ i + " | " + devices[i]);
            } else {
                System.out.println("slot"+ i + " | empty" );
            }
        }
    }
}
