package com.netcracker.edu.inventory;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;
import com.netcracker.edu.inventory.model.impl.*;
import com.netcracker.edu.inventory.service.impl.ServiceImpl;

public class Main {

    public static void main(String[] args) {

        ServiceImpl service = new ServiceImpl();

        Battery b = new Battery();
        b.setType(Battery.class.getSimpleName());
        Router r = new Router();
        r.setType(Router.class.getSimpleName());
        Switch s = new Switch();
        s.setType(Switch.class.getSimpleName());
        WifiRouter wr = new WifiRouter();
        wr.setType(WifiRouter.class.getSimpleName());
        Device tn = new Battery();
        tn.setType(null);

        Device[] devices = new Device[] {null, r, b, tn, r, s, tn, null, wr, b};
        Device[] expResult = new Device[] {null, null, null, tn, null, null, tn, null, null, null};

        service.filtrateByType(devices, null);
//        service.filtrateByType(devices, r.getClass().getSimpleName());
//        showDevArray(devices);

        System.out.println("*******************************************************************");
        showDevArray(devices);

//        RackArrayImpl rack = new RackArrayImpl(15);
//
//        Battery battery = new Battery(4, "Battery", "DX Global", "XX5ST", null, 1);
//        Router router = new Router(20, "Router", "RT Manufacture", "Router1", null, 1000);
//        Switch swch = new Switch(3, "Switch", "SW Corp", "Switch1", null, 100, 8);
//        WifiRouter wifi = new WifiRouter(1, "WifiRouter", "Wifi Corp", "Wifi model1", null, 100,
//                "PROT1");
//
//        Device[] devices = new Device[] {null, battery, router, new Battery(), swch, wifi, null};
//
//        ServiceImpl service = new ServiceImpl();
//        service.sortByIN(devices);
//
//        showDevArray(devices);
//
//        service.filtrateByType(devices, null);
//        service.sortByIN(devices);
//
//        System.out.println("*******************************************************************");
//        showDevArray(devices);

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
