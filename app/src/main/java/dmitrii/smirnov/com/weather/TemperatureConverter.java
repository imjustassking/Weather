package dmitrii.smirnov.com.weather;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public class TemperatureConverter {

    public static Double kelvinToCelsius(String kelvin) throws NumberFormatException {
        double inKelvin;
        try {
            inKelvin = Double.parseDouble(kelvin);
        } catch (NumberFormatException e) {
            throw e;
        }
        return inKelvin - 273.15;
    }

    public static Double kelvinToFahrenheit(String kelvin) throws NumberFormatException {
        double inKelvin;
        try {
            inKelvin = Double.parseDouble(kelvin);
        } catch (NumberFormatException e) {
            throw e;
        }
        return (inKelvin - 273.15) * 1.8000 + 32.00;
    }

}
