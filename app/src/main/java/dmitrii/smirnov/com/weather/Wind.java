package dmitrii.smirnov.com.weather;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public class Wind {
    private String speed;

    private String deg;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "ClassPojo [speed = " + speed + ", deg = " + deg + "]";
    }
}
