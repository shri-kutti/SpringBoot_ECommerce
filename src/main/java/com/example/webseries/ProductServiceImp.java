package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public String upsertProduct(ProductModel product) {
        productRepo.save(product);
        return "Success";
    }

    @Override
    public List<ProductModel> getByType(String type) {
        return productRepo.findByType(type);
    }

    @Override
    public ProductModel getById(String id){
        Optional<ProductModel> findById = productRepo.findById(id);

        if(findById.isPresent())
            return findById.get();
        else
            return null;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public String deleteProduct(String id) {
        if(productRepo.existsById(id)){
            productRepo.deleteById(id);
            return "Deleted Successfully";
        } else{
            return "No record found";
        }
    }
}
