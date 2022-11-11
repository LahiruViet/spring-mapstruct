package com.example.demo.mapper;

import com.example.demo.dto.SimpleDestination;
import com.example.demo.entity.SimpleSource;
import com.example.demo.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SimpleDestinationMapperUsingInjectedServiceTest {

    @Autowired
    protected SimpleService simpleService;

    private SimpleDestinationMapperUsingInjectedService mapper =
            Mappers.getMapper(SimpleDestinationMapperUsingInjectedService.class);

    @Test()
    public void givenSourceToDestination_whenMaps_thenCorrect() {

        SimpleSource simpleSource = new SimpleSource();
        simpleSource.setName("SourceName");
        simpleSource.setDescription("SourceDescription");
        SimpleDestination destination = mapper.sourceToDestination(simpleSource, simpleService);

        assertEquals(simpleSource.getName() + " ENRICHED", destination.getName());
        assertEquals(simpleSource.getDescription(), destination.getDescription());
    }

    @Test
    public void givenDestinationToSource_whenMaps_thenCorrect() {

        SimpleDestination destination = new SimpleDestination();
        destination.setName("DestinationName");
        destination.setDescription("DestinationDescription");
        SimpleSource source = mapper.destinationToSource(destination);
        assertEquals(destination.getName(), source.getName());
        assertEquals(destination.getDescription(), source.getDescription());
    }
}
