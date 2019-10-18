package strategyPattern;

public class RedTshirtPredicate implements TshirtPredicate {

	@Override
	public boolean test(Tshirt tshirt) {
		System.out.println("We are in RedTshirtPredicate");
		return "RED".equals(tshirt.getColor());
	}

}
