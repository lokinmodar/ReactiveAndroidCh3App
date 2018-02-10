package br.com.theoldpinkeye.reactiveandroidch3app.yahoo;

import br.com.theoldpinkeye.reactiveandroidch3app.yahoo.json.YahooStockResult;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Just Us on 08/02/2018.
 */

public interface YahooService {

    @GET("yql?format=json")
    Single<YahooStockResult> yqlQuery(
            @Query("q") String query,
            @Query("env") String env
    );
}
