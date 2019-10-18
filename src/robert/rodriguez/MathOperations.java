package robert.rodriguez;

public class MathOperations {

	public static void main(String[] args) {
		int daysFromRegistration = 100;

		System.out.println("::" + (daysFromRegistration / 30));
		System.out.println((int) (daysFromRegistration / 30));
		int daysFromStartOfPeriod = ((int) (daysFromRegistration / 30)) * 30 - daysFromRegistration;
		System.out.println(daysFromStartOfPeriod);

		Integer num1 = new Integer(10);
		Integer num2 = new Integer(20);
		Integer num3 = new Integer(10);
		Integer num4 = new Integer(30);
		// as num1<num2, Output will be a value less than zero
		System.out.println(num1.compareTo(num2));
		// as num1 = num3, Output will be zero
		System.out.println("-- " + num1.compareTo(num3));
		// as num4 > num2, Output will be a value greater than zero
		System.out.println(num4.compareTo(num2));
	}
}
