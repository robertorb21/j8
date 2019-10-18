package robert.rodriguez;

public class GetEnumValues {

	public static void main(String[] args) {
		System.out.println(EnumValues.GAFI);
		System.out.println(EnumValues.GAFI.getEnumValues());
		System.out.println(EnumValues.values()[0]);
		System.out.println(EnumValues.values()[1]);
		System.out.println(EnumValues.values()[2]);
	}
}
