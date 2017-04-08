package dmitrii.smirnov.com.weather;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public abstract class WeatherCallback {
    public abstract void success(WeatherResponseModel response);

    public abstract void failure(String message);
}
