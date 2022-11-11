package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public String enrichName(String name) {
        return name + " ENRICHED";
    }
}
