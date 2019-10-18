package strategyPattern;

import java.util.List;

public class ValidateTshirt {

	public static void main(String[] args) {
		Tshirt tshirt = new Tshirt();
		tshirt.setColor("RED");
		tshirt.setSize("XL");
		ValidateTshirt validateTshirt = new ValidateTshirt();
		
//		validateTshirt.filter(tshirt, validateTshirt);
	}

	public static void filter(Tshirt tshirt, TshirtPredicate tshirtPredicate) {
			if (tshirtPredicate.test(tshirt)) {
				System.out.println("Yeah, it is the thsirt");
			}
	}
}
