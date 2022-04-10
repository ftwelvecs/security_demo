package kz.f12.school.securitydemo.dto;

import kz.f12.school.securitydemo.enums.ProductType;
import kz.f12.school.securitydemo.enums.Quarter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportDto {
    private Long id;
    private String title;
    private Quarter quarter;
    private Integer sold;
    private ProductType productType;
    private double totalProfit;
}
