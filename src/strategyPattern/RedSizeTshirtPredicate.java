package strategyPattern;

public class RedSizeTshirtPredicate implements TshirtPredicate {

	@Override
	public boolean test(Tshirt tshirt) {
		System.out.println("We are in the Red and Size Tshit Predicate");
		return "RED".equals(tshirt.getColor()) && "XL".equals(tshirt.getSize());
	}

}
