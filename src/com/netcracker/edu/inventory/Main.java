package com.netcracker.edu.inventory;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;
import com.netcracker.edu.inventory.model.impl.*;
import com.netcracker.edu.inventory.service.impl.ServiceImpl;

public class Main {

    public static void main(String[] args) {

        RackArrayImpl rack = new RackArrayImpl(15);

        Battery battery = new Battery(4, "Battery", "DX Global", "XX5ST", null, 1);
        Router router = new Router(20, "Router", "RT Manufacture", "Router1", null, 1000);
        Switch swch = new Switch(3, "Switch", "SW Corp", "Switch1", null, 100, 8);
        WifiRouter wifi = new WifiRouter(1, "WifiRouter", "Wifi Corp", "Wifi model1", null, 100,
                "PROT1");

        Device[] devices = new Device[] {null, battery, router, new Battery(), swch, wifi, null};

        ServiceImpl service = new ServiceImpl();
        service.sortByIN(devices);

        showDevArray(devices);

        service.filtrateByType(devices, null);
        service.sortByIN(devices);

        System.out.println("*******************************************************************");
        showDevArray(devices);

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
