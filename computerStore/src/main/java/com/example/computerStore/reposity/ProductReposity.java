package com.example.computerStore.reposity;

import java.util.List;
import java.util.Optional;

import com.example.computerStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposity extends JpaRepository<Product,Long>{
    public List<Product> findAll();
    @Query("select p from Product p, Brand b where p._brandId = b._id and LOWER(b._brand) = LOWER(:brand)")
    public Optional<List<Product>> findByBrand(String brand);
    @Query("select p from Product p where p._name like LOWER(concat('%',:name,'%'))")
    public Optional<List<Product>> findByNameContainingInsensitive(String name);
}
