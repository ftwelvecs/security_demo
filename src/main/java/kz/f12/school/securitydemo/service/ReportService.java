package kz.f12.school.securitydemo.service;

import kz.f12.school.securitydemo.dto.ReportDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static kz.f12.school.securitydemo.enums.Quarter.*;
import static kz.f12.school.securitydemo.enums.ProductType.*;

@Service
public class ReportService {

    private final List<ReportDto> reports = Stream.of(
            new ReportDto(1L, "Отчеты за 1 квартал", Q1, 120, TECHNIQUE, 2_500_000),
            new ReportDto(2L, "Отчеты за 2 квартал", Q2, 70, CHEMICALS, 1_500_000),
            new ReportDto(3L, "Отчеты за 3 квартал", Q3, 85, FOOD, 5_500_000),
            new ReportDto(4L, "Отчеты за 4 квартал", Q4, 20, FURNITURE, 7_500_000)
    ).collect(Collectors.toList());

    public List<ReportDto> getReports() {
        return reports;
    }
}
