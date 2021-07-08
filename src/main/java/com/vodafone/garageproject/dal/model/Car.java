package com.vodafone.garageproject.dal.model;

public class Car extends Vehicle {

    public Car(String plateNumber, String color) {
        this.setPlateNumber(plateNumber);
        this.setColor(color);
        this.setSlotSize(1);
    }
}
