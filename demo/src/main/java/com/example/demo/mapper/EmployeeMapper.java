package com.example.demo.mapper;

import com.example.demo.dto.DivisionDTO;
import com.example.demo.entity.Division;
import com.example.demo.entity.Employee;
import com.example.demo.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target="employeeId", source="entity.id")
    @Mapping(target="employeeName", source="entity.name")
    @Mapping(target="employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Mapping(target="id", source="dto.employeeId")
    @Mapping(target="name", source="dto.employeeName")
    @Mapping(target="startDt", source="dto.employeeStartDt", dateFormat="dd-MM-yyyy HH:mm:ss")
    Employee employeeDTOtoEmployee(EmployeeDTO dto);

    DivisionDTO divisionToDivisionDTO(Division entity);

    Division divisionDTOtoDivision(DivisionDTO dto);
}
