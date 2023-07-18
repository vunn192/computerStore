package com.example.computerStore.reposity;

import com.example.computerStore.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandReposity extends JpaRepository<Brand, Long> {
    public List<Brand> findAll();
}