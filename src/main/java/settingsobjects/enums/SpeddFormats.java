package settingsobjects.enums;

public enum SpeddFormats {
    MILE("mph"),KILOMETR("km/h"),KNOT("knots");

    SpeddFormats(String speed) {
        this.speed = speed;
    }

    public String getSpeed() {
        return speed;
    }

    String speed;
}
