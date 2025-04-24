package in.hcl.app.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.app.DTO.DailyStockReportDTO;
import in.hcl.app.entity.StockTradeDetail;
import in.hcl.app.repo.StockTradeDetailRepo;

@Service
public class ReportService {
	@Autowired
	private StockTradeDetailRepo tradeRepository;

	public List<StockTradeDetail> getTodayTrades() {
		LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
		LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);
		return tradeRepository.findAllByTradedDateTimeBetween(startOfDay, endOfDay);
	}

	public List<DailyStockReportDTO> getTodayReportByEmail(String email) {
		LocalDateTime start = LocalDate.now().atStartOfDay();
		LocalDateTime end = start.plusDays(1).minusNanos(1);

		List<StockTradeDetail> trades = tradeRepository.findAllByTradedDateTimeBetween(start, end).stream()
				.filter(trade -> trade.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());

		return trades.stream().map(trade -> {
			String currentPrice = formatCurrency(trade.getTradedPrice());
			String dayRange = formatCurrency(trade.getDayLow()) + " - " + formatCurrency(trade.getDayHigh());

			BigDecimal change = trade.getTradedPrice().subtract(trade.getPreviousClose())
					.divide(trade.getPreviousClose(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
			String percentChange = change.setScale(2, RoundingMode.HALF_UP) + "%";

			return new DailyStockReportDTO(trade.getStockCode(), trade.getStockName(), currentPrice, dayRange,
					percentChange);
		}).collect(Collectors.toList());
	}

	private String formatCurrency(BigDecimal amount) {
		return "₹" + amount.setScale(2, RoundingMode.HALF_UP);
	}

	public List<DailyStockReportDTO> getWeeklyReportByEmail(String email) {
	    LocalDateTime end = LocalDate.now().atStartOfDay().plusDays(1).minusNanos(1); // end = today 23:59:59
	    LocalDateTime start = end.minusDays(6).withHour(0).withMinute(0).withSecond(0).withNano(0); // start = 6 days ago 00:00:00

	    List<StockTradeDetail> trades = tradeRepository.findAllByTradedDateTimeBetween(start, end)
	            .stream()
	            .filter(trade -> trade.getEmail().equalsIgnoreCase(email))
	            .collect(Collectors.toList());

	    return trades.stream().map(trade -> {
	        String currentPrice = formatCurrency(trade.getTradedPrice());
	        String dayRange = formatCurrency(trade.getDayLow()) + " - " + formatCurrency(trade.getDayHigh());

	        BigDecimal change = trade.getTradedPrice()
	                .subtract(trade.getPreviousClose())
	                .divide(trade.getPreviousClose(), 4, RoundingMode.HALF_UP)
	                .multiply(BigDecimal.valueOf(100));
	        String percentChange = change.setScale(2, RoundingMode.HALF_UP) + "%";

	        return new DailyStockReportDTO(
	                trade.getStockCode(),
	                trade.getStockName(),
	                currentPrice,
	                dayRange,
	                percentChange
	        );
	    }).collect(Collectors.toList());
	}

}
