package br.com.theoldpinkeye.reactiveandroidch3app.yahoo.json;

import java.util.Date;

/**
 * Created by Just Us on 08/02/2018.
 */

public class YahooStockQuery {
    private int count;
    private Date created;
    private YahooStockResults results;

    public YahooStockResults getResults() {
        return results;
    }

    public Date getCreated() {
        return created;
    }
}