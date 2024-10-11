//クラス、インスタンスあたりの話は実際にプログラムを作らないと
//ピンとこないので、以下でバトル・プログラムを作成する。

//クラスは神様のクラス、マリオのクラス、エビワラーのクラスの３つで作ってみる
//そして、マリオとエビワラーをインスタンス化し、神様のクラス上で操作する。

import java.util.*;

public class Battle3 extends Thread {

	public static void main(String[] args) {

		println("\n使用キャラクターを2体選択");
		
		CharacterPicker characterPicker = new CharacterPicker();
		Character character1 = characterPicker.chooseCharacter1();
		Character character2 = characterPicker.chooseCharacter2();

		Mario mario = new Mario();

		println("\n敵のマリオが現れた！！！");

		while (!(character1.isDead() && character2.isDead()) || (mario.isDead())) { //勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す

			showStatus(mario, character1, character2);
			
			int attackNoForCharacter1 = 0;
			int attackNoForCharacter2 = 0;

			if (!character1.isDead()) {
				attackNoForCharacter1 = character1.selectAttack();
				breakLine();
			}
			if (!character2.isDead()) {
				attackNoForCharacter2 = character2.selectAttack();
				breakLine();
			}

			sleep(800);

			if (!character1.isDead()) {
				character1.callAttack(attackNoForCharacter1, mario, character1, character2);
				breakLine();

				sleep(1400);
			}

			if (!character2.isDead()) {
				character2.callAttack(attackNoForCharacter2, mario, character1, character2);
				breakLine();

				sleep(1400);
			}

			if (mario.isDead()) {
				break;
			}

			if (!character1.isDead() && !character2.isDead()) {
				int oneOrTwo = new Random().nextInt(2) + 1;

				switch (oneOrTwo) {
					case 1:
						mario.callAttack(character1);
						break;
					case 2:
						mario.callAttack(character2);
						break;
				}
			} else if (character1.isDead()) {
				mario.callAttack(character2);
			} else if (character2.isDead()) {
				mario.callAttack(character1);
			}
			
			breakLine();

			sleep(2000);
		}

		showStatus(mario, character1, character2);

		//上のループの仕組みにより、以下２つのif構文のうち、必ず１つだけが実行される。

		if (mario.isDead()) {
			println(character1.getNamae() + "&" + character2.getNamae() + "のチームの勝ち！");
		}
		
		if (character1.isDead() && character2.isDead()) {
			println("マリオの勝ち！");
		}
	}

	private static void print(String text) {
		System.out.print(text);
	}

	private static void println(String text) {
		System.out.println(text);
	}

	private static void breakLine() {
		println(" ");
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException g) {
			// NOP
		}
	}

	private static void showStatus(Mario mario, Character character1, Character character2) {

		println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		println("マリオHP：" + mario.getHp() + "\n");
		print(character1.getNamae() + "HP：" + character1.getHp() + "  ");
		println(character2.getNamae() + "HP：" + character2.getHp());
		println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");	
	}
}