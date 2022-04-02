package kz.f12.school.securitydemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
}
