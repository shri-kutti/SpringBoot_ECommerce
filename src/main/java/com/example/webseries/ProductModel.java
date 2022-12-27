package com.example.webseries;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="product_table")
public class ProductModel {
    @Id
    private String productId;
    private String productName;
    private String description;
    private String quantity;
    private String price;
    private String type;
}
