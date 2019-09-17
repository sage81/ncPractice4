package com.netcracker.edu.inventory.model.impl;

import java.util.Date;

public class Battery extends AbstractDevice {

    private int chargeVolume;

    public Battery() {
    }

    public Battery(int in, String type, String manufacturer, String model, Date productionDate, int chargeValume) {
        super(in, type, manufacturer, model, productionDate);
        this.chargeVolume = chargeValume;
    }

    public int getChargeVolume() {
        return chargeVolume;
    }

    public void setChargeVolume(int chargeVolume) {
        this.chargeVolume = chargeVolume;
    }

    @Override
    public String toString() {
        return super.toString() + " Battery{" +
                "chargeValume=" + chargeVolume +
                '}';
    }
}
