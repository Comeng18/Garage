package com.vodafone.garageproject.dal.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Vehicle {

    String plateNumber;

    String color;

    int slotSize;

    List<Integer> consumedSlots;

    public void setConsumedSlots(int firstSlot) {
        List<Integer> consumedSlots = new ArrayList<>();
        for (int i = 0; i < this.getSlotSize(); i++) {
            consumedSlots.add(firstSlot + i);
        }

        this.consumedSlots = consumedSlots;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getPlateNumber())
                .append(" ")
                .append(this.getColor())
                .append(" ")
                .append(this.getConsumedSlots());

        return builder.toString();
    }
}
