
public class Util {

	public static void breakLine() {
		System.out.println(" ");
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException g) {
			// NOP
		}
	}
}