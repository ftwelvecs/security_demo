package kz.f12.school.securitydemo.dto;

import kz.f12.school.securitydemo.enums.ProductType;
import kz.f12.school.securitydemo.enums.Quarter;

public class ReportDto {
    private String title;
    private Quarter quarter;
    private Integer sold;
    private ProductType productType;
    private double totalProfit;
}
