package dmitrii.smirnov.com.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public interface WeatherInterface {

    @GET("weather")
    Call<WeatherResponseModel> getCityWeather(@Query("appid")String appid,
                                              @Query("q") String city);

    @GET("weather")
    Call<WeatherResponseModel> getLocationWeather(@Query("appid") String appid,
                                                  @Query("lat") String latitude,
                                                  @Query("lon") String longitude);

    @GET("forecast")
    Call<ForecastResponseModel> getCityForecast(@Query("appid") String appid,
                                               @Query("q") String city);

    @GET("forecast")
    Call<ForecastResponseModel> getLocationForecast(@Query("appid") String appid,
                                                    @Query("lat") String latitude,
                                                    @Query("lon") String longitude);


}
