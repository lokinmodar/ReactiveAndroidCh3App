package br.com.theoldpinkeye.reactiveandroidch3app.storio;

import android.content.ContentValues;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio3.sqlite.operations.put.DefaultPutResolver;
import com.pushtorefresh.storio3.sqlite.queries.InsertQuery;
import com.pushtorefresh.storio3.sqlite.queries.UpdateQuery;

import br.com.theoldpinkeye.reactiveandroidch3app.StockUpdate;

/**
 * Created by Just Us on 26/02/2018.
 */

public class StockUpdatePutResolver extends DefaultPutResolver<StockUpdate> {
    @NonNull
    @Override //is used to look up the right table where the data will be inserted
    protected InsertQuery mapToInsertQuery(@NonNull StockUpdate object) {
        return InsertQuery.builder()
                .table(StockUpdateTable.TABLE)
                .build();
    }

    @NonNull
    @Override //is used to issue queries to look up whether the object that we are trying to save is already in the database or not
    protected UpdateQuery mapToUpdateQuery(@NonNull StockUpdate object) {
        return UpdateQuery.builder()
                .table(StockUpdateTable.TABLE)
                .where(StockUpdateTable.Columns.ID + " = ?")
                .whereArgs(object.getId())
                .build();

    }

    @NonNull
    @Override //maps the values from the domain object to the ContentValues object that the SQLite database can digest.
    protected ContentValues mapToContentValues(@NonNull StockUpdate object) {
        final ContentValues contentValues = new ContentValues();

        contentValues.put(StockUpdateTable.Columns.ID, object.getId());
        contentValues.put(StockUpdateTable.Columns.STOCK_SYMBOL, object.getStockSymbol());
        contentValues.put(StockUpdateTable.Columns.PRICE, getPrice(object));
        contentValues.put(StockUpdateTable.Columns.DATE, getDate(object));
        return contentValues;
    }

    private long getPrice(@NonNull StockUpdate entity) {
        return entity.getPrice().scaleByPowerOfTen(4).longValue();
    }

    private long getDate(@NonNull StockUpdate entity) {
        return entity.getDate().getTime();
    }
}
