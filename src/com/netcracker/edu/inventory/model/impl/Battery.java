package com.netcracker.edu.inventory.model.impl;

import java.util.Date;

public class Battery extends AbstractDevice {

    private int chargeValume;

    public Battery() {
    }

    public Battery(int in, String type, String manufacturer, String model, Date productionDate, int chargeValume) {
        super(in, type, manufacturer, model, productionDate);
        this.chargeValume = chargeValume;
    }

    public int getChargeValume() {
        return chargeValume;
    }

    public void setChargeValume(int chargeValume) {
        this.chargeValume = chargeValume;
    }

    @Override
    public String toString() {
        return super.toString() + " Battery{" +
                "chargeValume=" + chargeValume +
                '}';
    }
}
