package com.codecika.reactivemongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    private String name;
    private String category;
    private BigDecimal price;
}
