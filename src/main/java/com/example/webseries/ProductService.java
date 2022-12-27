package com.example.webseries;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public String upsertProduct(ProductModel product);

    public List<ProductModel> getByType(String type);

    public ProductModel getById(String id);

    public List<ProductModel> getAllProducts();

    public String deleteProduct(String id);


}
