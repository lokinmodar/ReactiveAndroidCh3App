package br.com.theoldpinkeye.reactiveandroidch3app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Just Us on 07/02/2018.
 */

public class StockDataAdapter extends RecyclerView.Adapter<StockUpdateViewHolder>{
    private final List<StockUpdate> data = new ArrayList<>();

    @Override
    public StockUpdateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_update_item, parent, false);
        return new StockUpdateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StockUpdateViewHolder holder, int position) {
        StockUpdate stockUpdate = data.get(position);
        holder.setStockSymbol(stockUpdate.getStockSymbol());
        holder.setPrice(stockUpdate.getPrice());
        holder.setDate(stockUpdate.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size() != 0 ? data.size() : 0;
    }

    public void add(StockUpdate newStockUpdate) {
        for (StockUpdate stockUpdate : data){
            if (stockUpdate.getStockSymbol().equals(newStockUpdate.getStockSymbol())){
                if (stockUpdate.getPrice().equals((newStockUpdate.getPrice()))){
                    return;
                }
                break;
            }
        }
        this.data.add(0, newStockUpdate);
        notifyItemInserted(0);
    }
}
