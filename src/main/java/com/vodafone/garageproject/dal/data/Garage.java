package com.vodafone.garageproject.dal.data;

import com.vodafone.garageproject.dal.model.Vehicle;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Garage {

    HashMap<String, Vehicle> vehicleMap = new HashMap<>();

    String[] slots = new String[10];

    static Garage garage;

    public static Garage getInstance() {
        if (garage == null)
            garage = new Garage();

        return garage;
    }

    public boolean addCarToGarage(Vehicle vehicle) {

        int firstSlot = findParkingSpace(vehicle.getSlotSize());
        if (firstSlot < 0)
            return false;

        slots[firstSlot] = vehicle.getPlateNumber();
        vehicleMap.put(vehicle.getPlateNumber(), vehicle);
        vehicle.setConsumedSlots(firstSlot + 1);

        return true;
    }

    public int findParkingSpace(int slotSize) {

        int firsSlot = -1;
        int requiredSlotSize = slotSize + 1;

        for (int i = 0; i < 10; i++) {

            if (slots[i] == null) {
                if (firsSlot == -1)
                    firsSlot = i;

                requiredSlotSize--;
            } else {
                firsSlot = -1;
                requiredSlotSize = slotSize + 1;

                i += vehicleMap.get(slots[i]).getSlotSize();
            }

            if (requiredSlotSize == 0)
                return firsSlot;
        }

        return firsSlot;
    }

    public void removeCarFromGarage(int carNumber) {

        for (int i = 0; i < 10; i++) {
            String plateNumber = slots[i];
            if (plateNumber!= null) {
                carNumber--;
                if (carNumber == 0) {
                    vehicleMap.keySet().removeIf(f -> f.contains(plateNumber));
                    slots[i] = null;
                    return;
                }

                i += vehicleMap.get(plateNumber).getSlotSize();
            }
        }
    }
}
