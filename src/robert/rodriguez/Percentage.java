package robert.rodriguez;

import java.security.SecureRandom;

public class Percentage {

	public static void main(String[] args) {
		SecureRandom RANDOM = new SecureRandom();

		int p = RANDOM.nextInt(10) + 1;
		if (p <= 2) {
			System.out.println("New provided: " + p);
		} else {
			System.out.println("New provided: " + p);
		}
	}
}
