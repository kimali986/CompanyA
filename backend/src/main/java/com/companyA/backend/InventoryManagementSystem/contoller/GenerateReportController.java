package com.companyA.backend.InventoryManagementSystem.contoller;

import com.companyA.backend.InventoryManagementSystem.model.GenerateReport;
import com.companyA.backend.InventoryManagementSystem.model.Suppliers;
import com.companyA.backend.InventoryManagementSystem.service.GenerateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class GenerateReportController {
    @Autowired
    private GenerateReportService generateReportService;

    /*
    @GetMapping("/generate")
    public GenerateReport generateReports(){
        return generateReportService.generateReport();
    } */

    @PostMapping("/create")
    public ResponseEntity<String> registerSupplier(@RequestBody GenerateReport report) {
        String repo =  generateReportService.createReport(report);
        return ResponseEntity.status(HttpStatus.OK).body(repo);
    }

    @GetMapping("/details")
    public List<GenerateReport> reportDetails(){
        return generateReportService.reportDetails();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReportById(@PathVariable String id) {
        try {
            generateReportService.deleteReportId(id);
            return ResponseEntity.ok("Report deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
