package org.webflowService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.webflowService.dto.ProductDto;
import org.webflowService.service.ProductService;

import java.util.List;

@RestController("/")
public class ApiController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAllProducts(){
        List<ProductDto> productDtos = productService.findAll();
        return  ResponseEntity.ok(productDtos);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDto>> findAll(){
        List<ProductDto> productDtos = productService.findAll();
        return  ResponseEntity.ok(productDtos);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable int id){
        ProductDto productDto = productService.findById(id);
        return  ResponseEntity.ok(productDto);
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<ProductDto> findByIdFeign(@PathVariable int id){
        ProductDto productDto = productService.findById(id);
        return  ResponseEntity.ok(productDto);
    }

}
