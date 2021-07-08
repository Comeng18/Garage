package com.vodafone.garageproject.dal.model;

public class Jeep extends Vehicle {

    public Jeep(String plateNumber, String color) {
        this.setPlateNumber(plateNumber);
        this.setColor(color);
        this.setSlotSize(2);
    }
}
