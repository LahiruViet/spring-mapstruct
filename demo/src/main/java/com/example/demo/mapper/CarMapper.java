package com.example.demo.mapper;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.BioDieselCar;
import com.example.demo.entity.Car;
import com.example.demo.entity.ElectricCar;
import com.example.demo.enums.FuelType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CarMapper {

    public static CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @BeforeMapping
    protected void enrichDTOWithFuelType(Car car, @MappingTarget CarDTO carDto) {
        if (car instanceof ElectricCar) {
            carDto.setFuelType(FuelType.ELECTRIC);
        }
        if (car instanceof BioDieselCar) {
            carDto.setFuelType(FuelType.BIO_DIESEL);
        }
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget CarDTO carDto) {
        carDto.setName(carDto.getName().toUpperCase());
    }

    @Mapping(target = "fuelType", ignore = true)
    public abstract CarDTO toCarDto(Car car);
}
