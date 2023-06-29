package edu.hanu.app.Weather;

import edu.hanu.app.Weather.model.MyData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface weatherApi {
    @GET("weather")
    Call<MyData> getWeather(@Query("q") String cityName,
                            @Query("appid") String apiKey);
}
