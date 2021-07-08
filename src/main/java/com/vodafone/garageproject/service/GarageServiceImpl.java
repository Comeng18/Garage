package com.vodafone.garageproject.service;

import com.vodafone.garageproject.dal.data.Garage;
import com.vodafone.garageproject.dal.dto.CarInDTO;
import com.vodafone.garageproject.dal.model.Car;
import com.vodafone.garageproject.dal.model.Jeep;
import com.vodafone.garageproject.dal.model.Truck;
import com.vodafone.garageproject.dal.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService {

    @Override
    public String park(CarInDTO dto) {

        Vehicle vehicle;
        switch (dto.getCarType()) {
            case "Car":
                vehicle = new Car(dto.getPlateNumber(), dto.getColor());
                break;
            case "Truck":
                vehicle = new Truck(dto.getPlateNumber(), dto.getColor());
                break;
            case "Jeep":
                vehicle = new Jeep(dto.getPlateNumber(), dto.getColor());
                break;
            default:
                return "Input is invalid";
        }

        boolean isAdded = Garage.getInstance().addCarToGarage(vehicle);
        if (isAdded)
            return String.format("Allocated %d slot(s)", vehicle.getSlotSize());
        else
            return "Garage is full.";
    }

    @Override
    public void leave(Integer carNumber) {
        Garage.getInstance().removeCarFromGarage(carNumber);
    }

    @Override
    public List<String> status() {

        return Garage.getInstance().getVehicleMap()
                .values()
                .stream()
                .map(Vehicle::toString)
                .collect(Collectors.toList());
    }
}
