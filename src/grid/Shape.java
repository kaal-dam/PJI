package grid;

public enum Shape {
	TRIANGLE, SQUARE, CIRCLE;
    public static Shape getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
