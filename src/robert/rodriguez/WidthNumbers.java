package robert.rodriguez;

import java.math.BigDecimal;

public class WidthNumbers {

	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("5.23");
		System.out.println(bd);


		BigDecimal bd2 = new BigDecimal("5,23".replaceAll(",", "."));
		System.out.println(bd2);
	}
}
