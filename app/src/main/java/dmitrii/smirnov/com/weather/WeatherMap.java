package dmitrii.smirnov.com.weather;

/**
 * Created by Дмитрий on 08.04.2017.
 */

import android.content.Context;
import retrofit2.Call;

public class WeatherMap {
    Context context;
    String APP_ID;

    public WeatherMap(Context context, String APP_ID) {
        this.context = context;
        this.APP_ID = APP_ID;
    }

    public void getCityWeather(String city, final WeatherCallback weatherCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getCityWeather(APP_ID, city);

            if (objCall != null) {
                objCall.enqueue(new WeatherRetrofitCallback<WeatherResponseModel>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {

                        weatherCallback.failure("Failed");
                        super.onFailure(call, t);
                    }

                    @Override
                    protected void onResponseWeatherResponse(Call call, retrofit2.Response response) {

                        if (!response.isSuccessful())
                            weatherCallback.failure("Failed");
                    }

                    @Override
                    protected void onResponseWeatherObject(Call call, WeatherResponseModel response) {

                        weatherCallback.success(response);
                    }

                    @Override
                    protected void common() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationWeather(String latitude, String longitude, final WeatherCallback weatherCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getLocationWeather(APP_ID, latitude, longitude);

            if (objCall != null) {
                objCall.enqueue(new WeatherRetrofitCallback<WeatherResponseModel>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {

                        weatherCallback.failure("Failed");
                        super.onFailure(call, t);
                    }

                    @Override
                    protected void onResponseWeatherResponse(Call call, retrofit2.Response response) {

                        if (!response.isSuccessful())
                            weatherCallback.failure("Failed");
                    }

                    @Override
                    protected void onResponseWeatherObject(Call call, WeatherResponseModel response) {

                        weatherCallback.success(response);
                    }

                    @Override
                    protected void common() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCityForecast(String city, final ForecastCallback forecastCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getCityForecast(APP_ID, city);

            if (objCall != null) {
                objCall.enqueue(new WeatherRetrofitCallback<ForecastResponseModel>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {

                        forecastCallback.failure("Failed");
                        super.onFailure(call, t);
                    }

                    @Override
                    protected void onResponseWeatherResponse(Call call, retrofit2.Response response) {

                        if (!response.isSuccessful())
                            forecastCallback.failure("Failed");
                    }

                    @Override
                    protected void onResponseWeatherObject(Call call, ForecastResponseModel response) {

                        forecastCallback.success(response);
                    }

                    @Override
                    protected void common() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationForecast(String latitude, String longitude, final ForecastCallback forecastCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getLocationForecast(APP_ID, latitude, longitude);

            if (objCall != null) {
                objCall.enqueue(new WeatherRetrofitCallback<ForecastResponseModel>(context) {

                    @Override
                    public void onFailure(Call call, Throwable t) {

                        forecastCallback.failure("Failed");
                        super.onFailure(call, t);
                    }

                    @Override
                    protected void onResponseWeatherResponse(Call call, retrofit2.Response response) {

                        if (!response.isSuccessful())
                            forecastCallback.failure("Failed");
                    }

                    @Override
                    protected void onResponseWeatherObject(Call call, ForecastResponseModel response) {

                        forecastCallback.success(response);
                    }

                    @Override
                    protected void common() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
