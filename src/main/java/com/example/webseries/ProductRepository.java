package com.example.webseries;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;


public interface ProductRepository extends JpaRepository<ProductModel, Serializable>{

    List<ProductModel> findByType(String name);
}
