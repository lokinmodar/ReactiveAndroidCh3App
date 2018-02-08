package br.com.theoldpinkeye.reactiveandroidch3app;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Just Us on 07/02/2018.
 */

public class StockUpdateViewHolder extends RecyclerView.ViewHolder {
    private static final NumberFormat PRICE_FORMAT = new DecimalFormat("0,00");



    @BindView(R.id.stock_item_symbol)
    TextView stockSymbol;
    @BindView(R.id.stock_item_date)
    TextView date;
    @BindView(R.id.stock_item_price)
    TextView price;

    public StockUpdateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol.setText(stockSymbol);
    }

    public void setDate(Date date) {
        this.date.setText(DateFormat.format("yyyy-MM-dd hh:mm", date));
    }

    public void setPrice(BigDecimal price) {
        this.price.setText(PRICE_FORMAT.format(price.floatValue()));
    }

}
