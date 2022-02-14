package com.nttdata.productservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Product {
    @Id
    private String id;
    private String name;
    private ProductType type;
    private LocalDate date;
}
