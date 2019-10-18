package robert.rodriguez;

import java.math.BigInteger;

public class GenerateClabeWallet {
	public static void main(String[] args) {

		GenerateClabeWallet g = new GenerateClabeWallet();
		String clabe = "";
		String account = "10412401";// aqui
		String withCeros = g.leadZeros(account, 7);
		String cuenta = "6461801425" + withCeros;
		BigInteger ponderacion = new BigInteger("37137137137137137");

		// System.out.println(cuenta.toString().split("")[0]);

		cuenta = "64618014250661150";
//		cuenta = "64618014251041240";
		for (int i = 0; i < 10; i++) {
			int sumDV = 0;
			for (int j = 0; j < cuenta.toString().length(); j++) {
				sumDV += Integer.valueOf(cuenta.toString().split("")[j])
						* Integer.valueOf(ponderacion.toString().split("")[j]) % 10;
			}
			int modAd = sumDV % 10;
			int DV = (10 - modAd) % 10;
			clabe = cuenta + DV;
			System.out.println("+" + clabe);
		}

	}

	private String leadZeros(String str, int len) {
		if (str == null) {
			str = "";
		}
		str = str.trim();
		while (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}

}
