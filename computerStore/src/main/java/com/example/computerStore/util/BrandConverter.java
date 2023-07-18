package com.example.computerStore.util;

import com.example.computerStore.dto.BrandDTO;
import com.example.computerStore.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandConverter {
    public static BrandDTO toBrandDTO(Brand brand) {
        return new BrandDTO(
                brand.get_id(),
                brand.get_brand());
    }
    public static List<BrandDTO> toProductsDTO(List<Brand> productList) {
        List<BrandDTO> productDTOList = new ArrayList<>();

        for (Brand c: productList){
            productDTOList.add(BrandConverter.toBrandDTO(c));
        }
        return productDTOList;
    }
}
