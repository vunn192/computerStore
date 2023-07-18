package com.example.computerStore.util;

import com.example.computerStore.model.Product;
import com.example.computerStore.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
public class ProductConverter {
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.get_id(),
                product.get_img(),
                product.get_name(),
                product.get_price(),
                product.get_desc(),
                product.get_warranty(),
                product.get_brandId());
    }

    public static List<ProductDTO> toProductsDTO(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product c: productList){
            productDTOList.add(ProductConverter.toProductDTO(c));
        }
        return productDTOList;
    }

    public static Product toProduct(ProductDTO dto){
        return new Product(
                dto.get_id(),
                dto.get_img(),
                dto.get_name(),
                dto.get_price(),
                dto.get_desc(),
                dto.get_warranty(),
                dto.get_brand(),
                null);
    }
}
