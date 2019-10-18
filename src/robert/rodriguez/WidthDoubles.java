package robert.rodriguez;

public class WidthDoubles {

	public static void main(String[] args) {
		Double amount = 92500.9;
		Double usdDollar = Double.valueOf("18.5");
		Double maxPermitedPesos = usdDollar * 5000.0;
		System.out.println(amount + "  " + maxPermitedPesos);

		System.out.println("---: " + Double.compare(amount, maxPermitedPesos));
		if (Double.compare(amount, maxPermitedPesos) >= 0) {
			System.out.println("Reportamos");
		}
	}
}
