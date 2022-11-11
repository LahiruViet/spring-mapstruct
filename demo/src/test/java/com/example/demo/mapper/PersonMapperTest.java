package com.example.demo.mapper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonMapperTest {

    @Test
    public void givenPersonEntityToPersonWithExpression_whenMaps_thenCorrect() {

        Person entity  = new Person();
        entity.setName("Micheal");

        PersonDTO personDto = PersonMapper.INSTANCE.personToPersonDTO(entity);

        assertNull(entity.getId());
        assertNotNull(personDto.getId());
        assertEquals(personDto.getName(), entity.getName());
    }
}
