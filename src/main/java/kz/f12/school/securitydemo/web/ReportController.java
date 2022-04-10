package kz.f12.school.securitydemo.web;

import kz.f12.school.securitydemo.dto.ReportDto;
import kz.f12.school.securitydemo.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    @PreAuthorize("hasAuthority('REPORT_READ')")
    public List<ReportDto> getReports() {
        return reportService.getReports();
    }

}
