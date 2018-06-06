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
		
		// Sino la pones como final en el segundo sysout no se verá está variable pues no está en su scope
		final String prefix = "Okok.. ";
		System.out.println(processHere(".. proccesing", prefix::concat));
		
		System.out.println(processHere("... proccesing", str -> {
			return prefix.concat(str);
		}));
		
		
		String[] names = {"Mr. America", "Mr. Robert", "Ms. July", "Dr. Strange"};
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				return name1.split(" ")[1].compareTo(name2.split(" ")[1]);
			}
		});
		System.out.println(Arrays.toString(names));
	}

	private static String processHere2(String string, int i, BiFunction<String, Integer, String> manageString) {
		return manageString.apply(string, i);
	}

	private static String processHere(String str, Function<String, String> manageString) {
		return manageString.apply(str);
	}

	
}
