package robert.rodriguez;

import java.util.ArrayList;
import java.util.List;

public class MyCollections {

	public static void main(String[] args) {
		List<String> goodCodes = new ArrayList<>();
		goodCodes.add("507360005202");
		goodCodes.add("507360007597");
		goodCodes.add("507360007843");			
		
		for (String string : goodCodes) {
			String uniqueGoodCode = goodCodes.get(0);
			goodCodes.remove(uniqueGoodCode);
			System.out.println(uniqueGoodCode);
		}
		
		for (String string : goodCodes) {
			System.out.println("++++++++++++++++++++++++++");
			System.out.println(string);
		}
	}
}
