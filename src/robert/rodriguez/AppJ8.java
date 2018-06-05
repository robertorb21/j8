package robert.rodriguez;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AppJ8 {
	public static void main(String[] args) {
		System.out.println(processHere("Ok, Proccesing...", str -> str.toLowerCase()));
		// Using Method References simplefied
		System.out.println(processHere("Ok, Proccesing...", String::toLowerCase));

		System.out.println(processHere2("Ok, Proccesing...", 5, (str, i) -> str.substring(i)));
		System.out.println(processHere2("Ok, Proccesing...", 5, String::substring));
	}

	private static String processHere2(String string, int i, BiFunction<String, Integer, String> manageString) {
		return manageString.apply(string, i);
	}

	private static String processHere(String str, Function<String, String> manageString) {
		return manageString.apply(str);
	}

}
