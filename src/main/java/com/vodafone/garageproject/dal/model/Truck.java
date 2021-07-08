package com.vodafone.garageproject.dal.model;

public class Truck extends Vehicle {

    public Truck(String plateNumber, String color) {
        this.setPlateNumber(plateNumber);
        this.setColor(color);
        this.setSlotSize(4);
    }
}
