package grid;

public enum Police {
	ROMAN, ARABEAN, DICE;
    public static Police getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
