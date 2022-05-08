package com.example.difference_clinic.repositories;



import java.util.List;

import com.example.difference_clinic.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Long>{
    
    public ProductEntity findById(long id);
    public ProductEntity findById(int id);
    // @Query(value = "SELECT p FROM ProductEntity p ORDER BY order")
    // public List<ProductEntity> findAll();
    public List<ProductEntity> findAllByOrderByIdDesc();

}
