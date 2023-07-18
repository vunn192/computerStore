package com.example.computerStore.controller;

import com.example.computerStore.dto.ProductDTO;
import com.example.computerStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam(name  = "q", required = false) Optional<String> query) {
        List<ProductDTO> productDTOList;
        if (query.isPresent()) {
            String queryValue = query.get();
            productDTOList = productService.findByNameContainingInsensitive(queryValue);
        } else {
            productDTOList = productService.findAllDTO();
        }
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity detailProduct(@PathVariable long id, Model model) {
        ProductDTO productDTO = productService.findById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/search-product/{brand}")
    public ResponseEntity<List<ProductDTO>> productByBrand(@PathVariable String brand){
        List<ProductDTO> productDTOList = productService.findByBrand(brand);
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }
}
