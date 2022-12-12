package com.devsuperior.myfirstproject;

import com.devsuperior.myfirstproject.entities.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyfirstprojectApplication.class, args);
    }

    // method that allows us to do something on application startup
    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(1L, "Electronics");
        Category cat2 = new Category(2L, "Books");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
    }
}
