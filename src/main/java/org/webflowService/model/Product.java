package org.webflowService.model;


import lombok.*;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String name;
    private int quantity;
    private double price;

}
