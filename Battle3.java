//クラス、インスタンスあたりの話は実際にプログラムを作らないと
//ピンとこないので、以下でバトル・プログラムを作成する。

//クラスは神様のクラス、マリオのクラス、エビワラーのクラスの３つで作ってみる
//そして、マリオとエビワラーをインスタンス化し、神様のクラス上で操作する。

public class Battle3 {

	public static void main(String[] args) {

		System.out.println("\n使用キャラクターを2体選択");

		CharacterPicker characterPicker = new CharacterPicker();
		Character character1 = characterPicker.chooseCharacter1();
		Character character2 = characterPicker.chooseCharacter2();

		Mario mario = new Mario();

		Referee referee = new Referee(mario, character1, character2);

		System.out.println("\n敵のマリオが現れた！！！");

		while (referee.isGameInProgress()) { //勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す

			referee.announceStatus();

			if (character1.isSurviving()) {
				character1.selectAttack();
				Util.breakLine();
			}

			if (character2.isSurviving()) {
				character2.selectAttack();
				Util.breakLine();
			}

			Util.sleep(800);

			if (character1.isSurviving()) {
				character1.callAttack(mario, character1, character2);
				Util.breakLine();

				Util.sleep(1400);
			}

			if (character2.isSurviving()) {
				character2.callAttack(mario, character1, character2);
				Util.breakLine();

				Util.sleep(1400);
			}

			if (mario.isDead()) {
				break;
			}

			mario.callAttack(character1, character2);
			
			Util.breakLine();

			Util.sleep(2000);
		}

		referee.announceStatus();
		referee.announceVictory();
	}
}