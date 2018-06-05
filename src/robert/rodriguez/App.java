package robert.rodriguez;

public class App {

	public static void main(String[] args) {
		// String version = System.getProperty("java.version");
		// int pos = version.indexOf('.');
		// pos = version.indexOf('.', pos+1);
		// System.out.println(Double.parseDouble (version.substring (0, pos)));

		System.out.println(processHere("Ok, Proccesing...", new ManageString() {
			public String manage(String str) {
				return str.toLowerCase();
			}
		}));
	}

	private static String processHere(String str, ManageString manageString) {
		return manageString.manage(str);
	}
}

@FunctionalInterface
interface ManageString {
	String manage(String str);
}
