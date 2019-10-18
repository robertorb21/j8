package robert.rodriguez;

import java.util.ArrayList;
import java.util.List;

public class Sttrings {
	public static void main(String[] args) {
		System.out.println(".1656565651616".matches("\\d+"));
		System.out.println("5204165144672098".length() == 18);
		String msisdn = "5543024702";
		System.out.println(msisdn.length());
		if (msisdn.length() == 12) {
			msisdn = msisdn.substring(2, msisdn.length());
			System.out.println(msisdn);
		}
		
		
		List<String> allowClients = new ArrayList<String>();
		allowClients.add("131");
		allowClients.add("127");
		allowClients.add("121");
		allowClients.add("145");
		allowClients.add("122");
		allowClients.add("123");
		allowClients.add("43391");
		
		System.out.println(allowClients.size());
		
		System.out.println("54392401".substring("54392401".length()-2));

		
		StringBuilder completeAccount = new StringBuilder();
		completeAccount.append("12345");
		completeAccount.append("1");
		System.out.println("Emisor+Account: " + completeAccount.toString());
		
		
		String name = "RobeRt Rodriguez";
		String dn = "5582850635";
		System.out.println("-- " + name.substring(0, 1) + "" + name.substring(1).replaceAll("[A-za-z]", "X"));
		System.out.println(name.substring(1));
		
		
		System.out.println(dn.substring(0, dn.length()-4));
		System.out.println(dn.substring(dn.length()-4));
		System.out.println(dn.substring(0, dn.length()-4).replaceAll("[0-9]", "X") + "" + dn.substring(dn.length()-4));
		
		

		String[] msisdnHelpDeskToNotify = {};
		msisdnHelpDeskToNotify = "ricardo@weex.mx,mike@weex.mx".split(",");
		for (String string : msisdnHelpDeskToNotify) {
			System.out.println(string);
		}
		
		String clabe = "45678906735";
		System.out.println(clabe.substring(0, 1));
		System.out.println(clabe.substring(clabe.length()-1));
		
		
		
		System.out.println("-1".equals(null));
	}
}
