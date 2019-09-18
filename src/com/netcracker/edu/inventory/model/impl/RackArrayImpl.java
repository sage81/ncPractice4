package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

import java.util.logging.Logger;

public class RackArrayImpl implements Rack {

    private final int size;
    private Device[] devices;
    private static Logger log = Logger.getLogger(RackArrayImpl.class.getName());

    public RackArrayImpl(int size) {
        if (size > 0) {
            this.size = size;
        } else {
            log.severe("Size of rack(" + size + ") can not be 0 or less");
            throw new IllegalArgumentException("Size of rack can not be 0 or less");
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
            throwIOOB(index);
        }

        return device;
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {

        boolean isInserted = false;

        if (!isSlotExist(index)) {
            return throwIOOB(index);
        } else if(!isDeviceValid(device)) {
            log.severe("Rack.insertDevToSlot " + device);
            throw new DeviceValidationException("Rack.insertDevToSlot", device);
        }

        if (isSlotAvailable(index) && device != null) {
            devices[index] = device.getIn() > 0 ? device : null;
            isInserted = (devices[index] != null);
        } else {
            log.warning("Slot" + index + " is not available");
        }

        return isInserted;
    }

    @Override
    public Device removeDevFromSlot(int index) {
        Device device = null;

        if (isSlotExist(index)) {
            if (isSlotAvailable(index)) {
                device = devices[index];
                devices[index] = null;
            } else {
                log.warning("Can not remove from empty slot " + index);
            }
        } else {
            throwIOOB(index);
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

    private boolean throwIOOB(int index) {
        log.severe("Wrong slot index["
                + index + "], should be in the range:0-" + (getSize() - 1));
        throw new IndexOutOfBoundsException("Wrong slot index["
                + index + "], should be in the range:0-" + (getSize() - 1));
    }

    public boolean isDeviceValid(Device device) {
        return device != null && device.getIn() > 0;
    }

}
