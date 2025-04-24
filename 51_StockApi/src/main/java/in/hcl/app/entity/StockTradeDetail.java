package in.hcl.app.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "STOCK_TRADE_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StockTradeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;

    @Column(name = "Stock_Code")
    private Integer stockCode;

    @Column(name = "Stock_name", nullable = false, length = 20)
    private String stockName;

    @Column(name = "Day_Open", precision = 8, scale = 2)
    private BigDecimal dayOpen;

    @Column(name = "Day_High", precision = 8, scale = 2)
    private BigDecimal dayHigh;

    @Column(name = "Day_Low", precision = 8, scale = 2)
    private BigDecimal dayLow;

    @Column(name = "Traded_Price", precision = 8, scale = 2)
    private BigDecimal tradedPrice;

    @Column(name = "Previous_Close", precision = 8, scale = 2)
    private BigDecimal previousClose;

    @Column(name = "TRADED_DATE_TIME", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime tradedDateTime;

}
