package dmitrii.smirnov.com.weather;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public abstract class ForecastCallback {
    public abstract void success(ForecastResponseModel response);

    public abstract void failure(String message);
}
