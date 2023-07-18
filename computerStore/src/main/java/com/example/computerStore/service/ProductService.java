package com.example.computerStore.service;

import java.util.List;
import java.util.Optional;

import com.example.computerStore.dto.ProductDTO;
import com.example.computerStore.model.Product;
import com.example.computerStore.reposity.ProductReposity;
import com.example.computerStore.util.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductReposity productReposity;

    @Autowired
    public ProductService(ProductReposity productReposity){
        this.productReposity = productReposity;
    }
    public List<ProductDTO> findAllDTO(){
        List<Product> productList = productReposity.findAll();
        return ProductConverter.toProductsDTO(productList);
    }

    public ProductDTO findById(long id){
        Optional<Product> optProduct = productReposity.findById(id);

        if (!optProduct.isPresent()){
            throw new RuntimeException("Not Found");
        }

        Product product = optProduct.get();
        return ProductConverter.toProductDTO(product);
    }

    public List<ProductDTO> findByBrand(String brand) {
        Optional<List<Product>> optProductList = productReposity.findByBrand(brand);

        if (!optProductList.isPresent()){
            throw new RuntimeException("Not Found");
        }

        List<Product> productList = optProductList.get();
        return ProductConverter.toProductsDTO(productList);
    }


    public List<ProductDTO> findByNameContainingInsensitive(String name) {
        Optional<List<Product>> optProductList = productReposity.findByNameContainingInsensitive(name);

        if (!optProductList.isPresent()){
            throw new RuntimeException("Not Found");
        }

        List<Product> productList = optProductList.get();
        return ProductConverter.toProductsDTO(productList);
    }
}
