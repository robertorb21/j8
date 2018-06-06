package robert.rodriguez;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AppJ8 {
	public static void main(String[] args) {
		System.out.println(processHere("Ok, Proccesing...", str -> str.toLowerCase()));
		// Using Method References simplefied
		System.out.println(processHere("Ok, Proccesing...", String::toLowerCase));

		System.out.println(processHere2("Ok, Proccesing...", 5, (str, i) -> str.substring(i)));
		System.out.println(processHere2("Ok, Proccesing...", 5, String::substring));
		
		String prefix = "Mr";
		System.out.println(processHere(" Robert", prefix::concat));
		
		String[] names = {"Mr. Strange", "Dr. Octopuy's", "Ms. Scarlett", "Mr. Robert Rodriguez"};
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.split(" ")[1].compareTo(o2.split(" ")[1]);
			}
		});
		System.out.println(Arrays.toString(names));
		// With lambda
		
		Arrays.sort(names,  (string1, string2) -> 
			string1.split(" ")[1].compareTo(string2.split(" ")[1])
		);
		System.out.println(Arrays.toString(names));
	}

	private static String processHere2(String string, int i, BiFunction<String, Integer, String> manageString) {
		return manageString.apply(string, i);
	}

	private static String processHere(String str, Function<String, String> manageString) {
		return manageString.apply(str);
	}

}
