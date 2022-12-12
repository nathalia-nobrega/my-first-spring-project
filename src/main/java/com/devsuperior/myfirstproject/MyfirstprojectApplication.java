package com.devsuperior.myfirstproject;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;
import com.devsuperior.myfirstproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyfirstprojectApplication.class, args);
    }

    // method that allows us to do something on application startup
    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        // product creates a reference to its category
        Product p1 = new Product(null, "TV", 2200.00, cat1);
        Product p2 = new Product(null, "Domain Driven Design", 120.00, cat2);
        Product p3 = new Product(null, "PS5", 2800.00, cat1);
        Product p4 = new Product(null, "Docker", 100.00, cat2);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);

        // category creates a reference to its product
        cat1.getProducts().addAll(Arrays.asList(p1, p3));
        cat2.getProducts().addAll(Arrays.asList(p2, p4));
    }
}
