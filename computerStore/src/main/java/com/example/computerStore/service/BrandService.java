package com.example.computerStore.service;

import com.example.computerStore.controller.BrandController;
import com.example.computerStore.dto.BrandDTO;
import com.example.computerStore.model.Brand;
import com.example.computerStore.reposity.BrandReposity;
import com.example.computerStore.util.BrandConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandReposity brandReposity;

    @Autowired
    public BrandService(BrandReposity brandReposity){
        this.brandReposity = brandReposity;
    }

    public List<BrandDTO> findAllDTO(){
        List<Brand> brandList = brandReposity.findAll();
        return BrandConverter.toProductsDTO(brandList);
    }
}
