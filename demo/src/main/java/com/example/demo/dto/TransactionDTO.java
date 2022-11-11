package com.example.demo.dto;

import lombok.Data;

@Data
public class TransactionDTO {

    private Long id;
    private String uuid;
    private Long totalInCents;

}
