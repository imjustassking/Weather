package dmitrii.smirnov.com.weather;

/**
 * Created by Дмитрий on 08.04.2017.
 */

public class Weather {
    private String id;

    private String icon;

    private String description;

    private String main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconLink() {
        return "http://openweathermap.org/img/w/" + icon + ".png";
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", icon = " + icon + ", description = " + description + ", main = " + main + "]";
    }
}
