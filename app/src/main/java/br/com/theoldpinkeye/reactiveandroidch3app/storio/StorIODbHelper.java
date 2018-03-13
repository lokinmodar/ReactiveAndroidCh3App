package br.com.theoldpinkeye.reactiveandroidch3app.storio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.annotation.Nonnull;

/**
 * Created by Just Us on 12/03/2018.
 */

public class StorIODbHelper extends SQLiteOpenHelper {

    StorIODbHelper(@Nonnull Context context){
        super (context, "reactivestocks.db",null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StockUpdateTable.createTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
