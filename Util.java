import java.util.Random;

public class Util {

    public static int pickRandomly(int[] args) {

        int randomIndex = new Random().nextInt(args.length);

        int randomElement = args[randomIndex];

        return randomElement;
    }

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