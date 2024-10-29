package org.webflowService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webflowService.dto.ProductDto;
import org.webflowService.model.Product;
import org.webflowService.service.data.ProductData;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private  ProductDto productDto;
    @Autowired
    ProductData productData;


    public List<ProductDto> findAll(){

        List<Product> products = productData.getProducts();
        List<ProductDto> productDtos = new ArrayList<>();

        for(Product product: products){
           productDto = getProduct(product);
           productDtos.add(productDto);
        }

        return productDtos;
    }

    public ProductDto findById(int id){
        int idValue = id -1;
       return findAll().get(idValue);
    }

    private ProductDto getProduct(Product product){

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }
}
