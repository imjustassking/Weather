package dmitrii.smirnov.com.weather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    private final String APP_ID = "dd90f7680bbc95af1a2d3b62ed3e1eef";
    private final String APP_ID = "18e453f0cee836e982015e65224d11f4";

    private String CITY_ID = "498817"; //Saint Petersburg
    private String CITY = "Saint Petersburg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Updating weather data", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                updateWeatherData();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    void updateWeatherData() {
        loadWeather(CITY);
    }

    private void loadWeather(String city) {
        WeatherMap weatherMap = new WeatherMap(this, APP_ID);
        weatherMap.getCityWeather(city, new WeatherCallback() {
            @Override
            public void success(WeatherResponseModel response) {
                populateWeather(response);
            }

            @Override
            public void failure(String message) {

            }
        });

        weatherMap.getCityForecast(city, new ForecastCallback() {
            @Override
            public void success(ForecastResponseModel response) {

            }

            @Override
            public void failure(String message) {

            }
        });
    }


    private void populateWeather(WeatherResponseModel response) {
        Weather weather[] = response.getWeather();
        TextView textView = (TextView) findViewById(R.id.tmp);
        textView.setText(weather[0].getMain());
        textView.append("\n");
        textView.append(TemperatureConverter.kelvinToCelsius(response.getMain().getTemp()).intValue() + " °C");
        textView.append("\n");
        textView.append(response.getName());
        textView.append("\n");
        textView.append(response.getMain().getHumidity() + "%");
        textView.append("\n");
        textView.append(response.getMain().getPressure() + " hPa");
        textView.append("\n");
        textView.append(response.getWind().getSpeed() + "m/s");
        textView.append("\n");
        textView.append(response.getWind().getDeg() + "°");

        String link = weather[0].getIconLink();
        Picasso.with(this).load(link).into((ImageView) findViewById(R.id.tmpImg));
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch (item.getItemId()) {
            case R.id.nav_Saint_Petersburg:
                CITY_ID = "498817";
                CITY = "Saint Petersburg";
                break;
            case R.id.nav_Moscow:
                CITY_ID = "524901";
                CITY = "Moscow";
                break;
            case R.id.nav_custom_location:

                break;
            case R.id.nav_current_weather:

                break;
            case R.id.nav_three_days_forecast:

                break;
            case R.id.nav_week_forecast:

                break;
            default:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
