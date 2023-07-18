package com.example.computerStore.controller;

import com.example.computerStore.dto.BrandDTO;
import com.example.computerStore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(value = "/laptop/{name}")
    public String productByBrand(@PathVariable String name) {
        return "hang";
    }

    @GetMapping(value = "/brands")
    public ResponseEntity<List<BrandDTO>> getBrands(){
        List<BrandDTO> brandDTOList = brandService.findAllDTO();
        return new ResponseEntity<>(brandDTOList, HttpStatus.OK);
    }
}