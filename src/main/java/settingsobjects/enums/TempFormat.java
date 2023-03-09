package settingsobjects.enums;

public enum TempFormat {
    FARENGATE(true),CELCII(false);

    public boolean isB() {
        return b;
    }

    boolean b;

    TempFormat(boolean b) {
        this.b=b;
    }
}
