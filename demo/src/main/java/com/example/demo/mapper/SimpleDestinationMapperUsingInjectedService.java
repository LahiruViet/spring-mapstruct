package com.example.demo.mapper;

import com.example.demo.dto.SimpleDestination;
import com.example.demo.entity.SimpleSource;
import com.example.demo.service.SimpleService;
import lombok.Data;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Data
public abstract class SimpleDestinationMapperUsingInjectedService {

    @Autowired
    protected SimpleService simpleService;

    @Mapping(target = "name", expression = "java(simpleService.enrichName(source.getName()))")
    public abstract SimpleDestination sourceToDestination(SimpleSource source, @Context SimpleService simpleService);

    public abstract SimpleSource destinationToSource(SimpleDestination destination);
}
