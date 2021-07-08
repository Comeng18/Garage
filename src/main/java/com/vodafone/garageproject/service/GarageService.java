package com.vodafone.garageproject.service;

import com.vodafone.garageproject.dal.dto.CarInDTO;

import java.util.List;

public interface GarageService {

    String park(CarInDTO dto);

    void leave(Integer carNumber);

    List<String> status();
}
