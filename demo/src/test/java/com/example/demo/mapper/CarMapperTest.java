package com.example.demo.mapper;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import com.example.demo.entity.ElectricCar;
import com.example.demo.enums.FuelType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarMapperTest {

    @Test
    public void givenElectricCar_then_setFuelTypeToElectric() {

        Car electricCar = new ElectricCar();
        electricCar.setId(1);
        electricCar.setName("Electric Car");

        CarDTO carDTO = CarMapper.INSTANCE.toCarDto(electricCar);

        assertEquals(FuelType.ELECTRIC.name(), carDTO.getFuelType().name());
    }

    @Test
    public void givenCarWithCarName_then_convertCarNameToUpperCase() {

        Car electricCar = new ElectricCar();
        electricCar.setId(1);
        electricCar.setName("Electric Car");

        CarDTO carDTO = CarMapper.INSTANCE.toCarDto(electricCar);

        assertEquals(electricCar.getName().toUpperCase(), carDTO.getName());
    }
}
