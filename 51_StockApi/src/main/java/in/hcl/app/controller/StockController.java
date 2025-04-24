package in.hcl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.app.DTO.DataReq;
import in.hcl.app.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	// Add stock to portfolio
	@PostMapping("/add")
	public String addStock(@RequestBody DataReq req) {
		return stockService.addStock(req.getStockCode(), req.getEmail());
	}

	// Remove stock from portfolio by code
	@DeleteMapping("/remove")
	public String removeStock(@RequestBody DataReq req) {
		return stockService.removeStock(req.getStockCode(), req.getEmail());
	}

	// Remove all stocks from portfolio
	@DeleteMapping("/remove/all/{email}")
	public String removeAllStocks(@PathVariable String email) {
		return stockService.removeAllStock(email);
	}
}
