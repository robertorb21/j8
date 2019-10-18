package robert.rodriguez;

import java.util.stream.IntStream;

public class Bitso {

	public static void main(String[] args) {
		System.out.println(IntStream.range(1,  5).map(n -> n*2).reduce(1, (a,b)->a+b));
	}
}
