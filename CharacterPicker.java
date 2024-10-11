import java.util.*;

public class CharacterPicker {

	private int chooseCharacter1 = 0;
	private int chooseCharacter2 = 0;

	public Character chooseCharacter1() {

		boolean isCorrect = false;

		do {
			System.out.println("【キャラクターNo.1】");
			System.out.print("エビワラー→１　魔法使い→２　原始人→３ フクロウ→４: ");
			chooseCharacter1 = new Scanner(System.in).nextInt();

			if (chooseCharacter1 < 1 || chooseCharacter1 > 4) {
				isCorrect = false;
			} else {
				isCorrect = true;
			}
		} while (!(isCorrect));

		return getCharacter(chooseCharacter1);
	}

	public Character chooseCharacter2() {

		boolean isCorrect = false;

		do {
			System.out.println("【キャラクターNo.2】");
			System.out.print("エビワラー→１　魔法使い→２　原始人→３ フクロウ→４: ");
			chooseCharacter2 = new Scanner(System.in).nextInt();

			if (chooseCharacter2 < 1 || chooseCharacter2 > 4) {
				isCorrect = false;
			} else if (chooseCharacter1 == chooseCharacter2) {	
				isCorrect = false;
				System.out.println("\n同じキャラクターは使用できません。。\n");
			} else {
				isCorrect = true;
			}
		} while (!(isCorrect));

		return getCharacter(chooseCharacter2);
	}

	private Character getCharacter(int number) {

		switch (number) {
			case 1:
				return new Ebiwara();
			case 2:
				return new Wizard();
			case 3:
				return new PrimitiveMan();
			case 4:
				return new Owl();
			default:
				return new Ebiwara();
		}
	}
}