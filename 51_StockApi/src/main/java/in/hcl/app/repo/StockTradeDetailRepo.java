package in.hcl.app.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.hcl.app.entity.StockTradeDetail;

public interface StockTradeDetailRepo extends JpaRepository<StockTradeDetail, Integer>{

	
	
	
	public List<StockTradeDetail> findByStockCode(Integer stockCode);
	public List<StockTradeDetail> findByEmail(String email);
	@Query("SELECT s FROM StockTradeDetail s WHERE s.tradedDateTime BETWEEN :start AND :end")
    List<StockTradeDetail> findAllByTradedDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
