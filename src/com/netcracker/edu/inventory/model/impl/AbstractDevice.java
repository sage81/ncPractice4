package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Date;

public abstract class AbstractDevice implements Device {

    private int in = 0;
    private String type;
    private String manufacturer;
    private String model;
    private Date productionDate;

    public AbstractDevice() {
    }

    public AbstractDevice(int in, String type, String manufacturer, String model, Date productionDate) {
        this.in = in;
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionDate = productionDate;
    }

    @Override
    public int getIn() {
        return this.in;
    }

    @Override
    public void setIn(int in) {
        if (this.in == 0 && in > 0) {
            this.in = in;
        }
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return this.productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "AbstractDevice{" +
                "in=" + in +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
