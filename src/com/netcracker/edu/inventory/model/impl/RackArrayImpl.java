package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

public class RackArrayImpl implements Rack {

    private final int size;
    private Device[] devices;

    public RackArrayImpl(int size) {
        if (size > 0) {
            this.size = size;
        } else  {
            showError("Size should be grater then 0");
            this.size = 0;
        }
        devices = new Device[this.size];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getFreeSize() {

        int freeSize = 0;

        for (Device dev : devices) {
            freeSize = (dev == null) ? freeSize + 1 : freeSize;
        }
        return freeSize;
    }

    @Override
    public Device getDevAtSlot(int index) {

        Device device = null;

        if (isSlotExist(index)) {
            device = devices[index];
        } else {
            showError("Slot" + index + " is not available");
        }

        return device;
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {

        boolean isInserted = false;

        if (isSlotAvailable(index) && device != null) {
            devices[index] = device.getIn() > 0 ? device : null;
            isInserted = (devices[index] != null);
        } else {
            showError("Slot" + index + " is not available");
        }

        return isInserted;
    }

    @Override
    public Device removeDevFromSlot(int index) {
        Device device = null;

        if (isSlotExist(index)) {
            device = devices[index];
            devices[index] = null;
        }

        return device;
    }

    @Override
    public Device getDevByIN(int in) {

        Device device = null;

        for (int i = 0; i < devices.length; i++) {
            if (!isSlotAvailable(i)) {
                if (devices[i].getIn() == in) {
                    device =  devices[i];
                    break;
                }
            }
        }

        return device;
    }

    public boolean isRackEmpty() {
        return devices.length == 0;
    }

    public boolean isSlotExist(int index) {
        return !isRackEmpty() && index >= 0 && index <= getSize() - 1;
    }

    public boolean isSlotEmpty(int index) {
        return isSlotExist(index) && devices[index] == null;
    }

    public boolean isSlotAvailable(int index) {
        return isSlotEmpty(index);
    }

    private void showError(String errMsg) {
        if (!errMsg.isEmpty()) {
            System.err.println(errMsg);
        }
    }

}
