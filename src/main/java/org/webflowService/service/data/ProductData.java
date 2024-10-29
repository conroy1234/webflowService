package org.webflowService.service.data;

import org.springframework.stereotype.Component;
import org.webflowService.model.Product;

import java.util.List;

@Component
public class ProductData {

    public  List<Product> getProducts(){
        List<Product> products = List.of(Product.builder()
                        .id(1)
                        .name("T shirt")
                        .price(20.3)
                        .quantity(2)
                .build(),
                Product.builder()
                        .id(2)
                        .name("Denim Jeans Pants")
                        .price(54.3)
                        .quantity(4)
                        .build(),
                Product.builder()
                        .id(3)
                        .name("perfume")
                        .price(100)
                        .quantity(1)
                        .build()

        );

        return products;

    }
}
