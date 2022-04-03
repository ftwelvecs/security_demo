package kz.f12.school.securitydemo.dto;

import kz.f12.school.securitydemo.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private ProductType type;
}
