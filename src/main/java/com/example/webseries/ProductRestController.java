package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductModel product){
        return new ResponseEntity<>(productService.upsertProduct(product), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getByType")
    public ResponseEntity<List<ProductModel>> getByType(@RequestBody ProductModel product){
        String ty = product.getType();
        return new ResponseEntity<>(productService.getByType(ty),HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<ProductModel> getByID(@RequestBody ProductModel product){
        String ty = product.getProductId();
        return new ResponseEntity<>(productService.getById(ty),HttpStatus.OK);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }


    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteSeries(@RequestBody ProductModel product){
        String ty = product.getProductId();
        return new ResponseEntity<>(productService.deleteProduct(ty),HttpStatus.OK);
    }

}
