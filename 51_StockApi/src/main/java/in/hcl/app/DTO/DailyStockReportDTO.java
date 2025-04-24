package in.hcl.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyStockReportDTO {

	
	private Integer stockCode;
    private String stockName;
    private String currentPrice;     // e.g. ₹1469.80
    private String dayRange;         // e.g. ₹1461.35 - ₹1488.80
    private String percentageChange; 
}
