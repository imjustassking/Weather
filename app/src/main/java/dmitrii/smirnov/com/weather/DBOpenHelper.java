package dmitrii.smirnov.com.weather;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = DBOpenHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "MainDatabase";
    public static final String TABLE_NAME = "MainTable";
    public static final String
            CITY_ID = "cityid",
            TEMPERATURE = "temperature",
            TEMP_MAX = "temperaturemax",
            TEMP_MIN = "temperaturemin",
            HUMIDITY = "humidity",
            PRESSURE = "pressure",
            WIND = "wind",
            WIND_DEG = "winddeg",
            DATE = "date";

    private static final int DATABASE_VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "DBOpenHelper constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v(LOG_TAG, "onCreate()");
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + CITY_ID + " TEXT NOT NULL , "
                + DATE + " TEXT NOT NULL , "
                + TEMPERATURE + " TEXT NOT NULL , "
                + TEMP_MIN + " TEXT NOT NULL , "
                + TEMP_MAX + " TEXT NOT NULL , "
                + HUMIDITY + " TEXT NOT NULL , "
                + PRESSURE + " TEXT NOT NULL , "
                + WIND + " TEXT NOT NULL , "
                + WIND_DEG + " TEXT NOT NULL );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "onUpgrade() from #" + oldVersion + " to #" + newVersion);
    }
}
