package robert.rodriguez;

public class LeadZeros {

	public static final String STP_INSTITUTION = "646";
	public static final String STP_PLAZA = "180";
	public static final String STP_PREFIJO = "1425";

	public static void main(String[] args) {
		StringBuilder completeAccount = new StringBuilder();
		completeAccount.append("4120");
		completeAccount.append("0");
		
		String cuenta = STP_INSTITUTION + STP_PLAZA + STP_PREFIJO
				+ leadZeros(completeAccount.toString(), 7);
		
		System.out.println(cuenta);
		String account = "646180142500412009";

		System.out.println(account + "--------------" + account.substring(0, account.length()-1));
		System.out.println(account);
		System.out.println(account.charAt(10));
		int x = Character.getNumericValue(account.charAt(10));
		do {
			System.out.println(" +  "+x);
		    String newAccunt = account.substring(0, 10) + x + account.substring(10+1);
			System.out.println("- " + newAccunt);
			x = x+1;
		} while (x <= 9);
	}

	private static String leadZeros(String str, int len) {
		if (str == null) {
			str = "";
		}
		str = str.trim();
		while (str.length() < len) {
			str = "0" + str;
		}
		
		System.out.println(str);
		return str;
	}
}
