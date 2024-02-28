package data;

public enum HairColor {
    RED(1),
    BLACK(2),
    YELLOW(3),
    WHITE(4),
    BROWN(5);
    private final int value;
    HairColor(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
