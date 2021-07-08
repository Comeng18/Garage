package com.vodafone.garageproject;

import com.vodafone.garageproject.dal.dto.CarInDTO;
import com.vodafone.garageproject.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GarageController {

    private final GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/garage")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok(garageService.status());
    }

    @PostMapping("/garage/car")
    public ResponseEntity<?> park(@RequestBody CarInDTO dto) {
        return ResponseEntity.ok(garageService.park(dto));
    }

    @DeleteMapping("/garage/car")
    public ResponseEntity<?> leave(@RequestParam Integer carNumber) {

        garageService.leave(carNumber);

        return ResponseEntity.ok().build();
    }
}
