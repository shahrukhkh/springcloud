package in.hcl.app.controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.app.DTO.DailyStockReportDTO;
import in.hcl.app.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class StockTradeReportController {

    private final ReportService reportService;

    public StockTradeReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/daily/{email}")
    public List<DailyStockReportDTO> getDailyReportByEmail(@PathVariable String email) {
        return reportService.getTodayReportByEmail(email);
    }
    
    @GetMapping("/weekly/{email}")
    public List<DailyStockReportDTO> getWeeklyReportByEmail(@PathVariable String email) {
        return reportService.getWeeklyReportByEmail(email);
    }
}

