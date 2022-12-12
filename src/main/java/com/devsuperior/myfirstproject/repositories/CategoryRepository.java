package com.devsuperior.myfirstproject.repositories;

import com.devsuperior.myfirstproject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//dependecy injection
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
