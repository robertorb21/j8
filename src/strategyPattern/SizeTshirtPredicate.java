package strategyPattern;

public class SizeTshirtPredicate implements TshirtPredicate {

	@Override
	public boolean test(Tshirt tshirt) {
		System.out.println("We are in SizeTshirtPredicate");
		return "XL".equals(tshirt.getSize());
	}

	
}
