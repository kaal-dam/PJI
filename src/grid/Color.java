package grid;

public enum Color {
	RED, BLUE, GREEN;
    public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
