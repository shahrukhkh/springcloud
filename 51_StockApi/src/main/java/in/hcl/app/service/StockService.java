package in.hcl.app.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.app.entity.StockTradeDetail;
import in.hcl.app.repo.StockTradeDetailRepo;

@Service
public class StockService {

	@Autowired
	private StockTradeDetailRepo tradeDetailRepo;

	public String addStock(Integer stockCode,String email) {

		StockTradeDetail dummyTrade = StockTradeDetail.builder().email(email.trim()).stockCode(stockCode)
				.stockName("INFY").dayOpen(new BigDecimal("1450.25")).dayHigh(new BigDecimal("1475.00"))
				.dayLow(new BigDecimal("1432.80")).tradedPrice(new BigDecimal("1462.50"))
				.previousClose(new BigDecimal("1448.60")).tradedDateTime(LocalDateTime.now()).build();
		
		dummyTrade.setId(null);
		return tradeDetailRepo.save(dummyTrade).getId() != null
				? "Hi, " + dummyTrade.getStockName() + " is added to your portfolio."
				: "Failed To add";
	}

	public String removeStock(Integer stockCode, String email) {
	    List<StockTradeDetail> byStockCode = tradeDetailRepo.findByStockCode(stockCode);

	    if (byStockCode.isEmpty()) {
	        return "No stock found with code: " + stockCode;
	    }

	    // Remove only the trades for the given email
	    List<StockTradeDetail> toRemove = byStockCode.stream()
	            .filter(s -> email.equals(s.getEmail()))
	            .toList();

	    if (toRemove.isEmpty()) {
	        return "No stock with code " + stockCode + " found for email: " + email;
	    }

	    tradeDetailRepo.deleteAll(toRemove);
	    String stockName = toRemove.get(0).getStockName();

	    return "Hi, " + stockName + " is removed from your portfolio.";
	}

	public String removeAllStock(String email) {
	    List<StockTradeDetail> byEmail = tradeDetailRepo.findAll();
	    List<StockTradeDetail> collect = byEmail.stream().filter(s->email.equals(s.getEmail())).collect(Collectors.toList());
	    if (collect.isEmpty()) {
	        return "No stocks found for email: " + email;
	    }

	    List<String> stockNames = collect.stream()
	            .map(StockTradeDetail::getStockName)
	            .distinct()
	            .toList();

	    tradeDetailRepo.deleteAll(collect);

	    return "Hi, " + stockNames + " stocks removed from your portfolio and your portfolio is now empty.";
	}

}
