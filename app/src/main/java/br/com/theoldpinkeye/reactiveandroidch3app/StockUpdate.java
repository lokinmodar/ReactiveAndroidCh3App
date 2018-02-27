package br.com.theoldpinkeye.reactiveandroidch3app;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.theoldpinkeye.reactiveandroidch3app.yahoo.json.YahooStockQuote;

/**
 * Created by Just Us on 07/02/2018.
 */

public class StockUpdate implements Serializable {
    private Integer id;
    private final String stockSymbol;
    private final BigDecimal price;
    private final Date date;

    public StockUpdate(String stockSymbol, BigDecimal price, Date date) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.date = date;
    }
    public Integer getId() {
        return id;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static StockUpdate create(YahooStockQuote r) {
        return new StockUpdate(r.getSymbol(), r.getLastTradePriceOnly(), new Date());
    }



}
