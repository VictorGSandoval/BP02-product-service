package com.nttdata.productservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("products")
public class Product {
    @Id
    private String id;
    private String name;
    private ProductType type;
    private LocalDate date;
}
