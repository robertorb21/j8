package robert.rodriguez;

public enum EnumValues {
	REFIPRES(1), GAFI(2), INTERNAL(3);

	private int type;

	private EnumValues(int type) {
		this.type = type;
	}

	public int getEnumValues() {
		return this.type;
	}

}
