package com.example.demo.dto;

import com.example.demo.enums.FuelType;
import lombok.Data;

@Data
public class CarDTO {

    private int id;
    private String name;
    private FuelType fuelType;
}
