package com.devsuperior.myfirstproject.resources;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    //dependecy injection
    @Autowired
    private ProductRepository ProductRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = ProductRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product>

    findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(ProductRepository.findById(id));
    }
}

