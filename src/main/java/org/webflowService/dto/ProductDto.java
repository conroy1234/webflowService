package org.webflowService.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private int id;
    private String name;
    private int quantity;
    private double price;
}
