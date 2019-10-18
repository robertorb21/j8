package eclipse;

public class DontKnow {
	public static void main(String[] args) {
		System.out.println(DontKnow.F(5));
	}

	public static int F(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return F(n - 1) + F(n - 2);
		}
	}
}
