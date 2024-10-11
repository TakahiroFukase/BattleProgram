import java.util.*;

public class Mario {
	//まずは、インスタンスが保有するべき情報をフィールドで宣言

	private int hp = 3000; //他のクラスからこの値を変えられないようになっている

	public void callAttack(Character character1, Character character2) {

		Character characterToAttack = chooseCharacterToAttack(character1, character2);

		if (characterToAttack == null) {
			// ここに入ることは基本あり得ないが、一応ケアしておく
			return;
		}

		int oneOrTwo = new Random().nextInt(2) + 1;

		switch (oneOrTwo) {
			case 1:
				fireBall(characterToAttack);
				break;
			case 2:
				throwShell(characterToAttack);
				break;
		}
	}

	private Character chooseCharacterToAttack(Character character1, Character character2) {

		if (!character1.isDead() && !character2.isDead()) {
			int oneOrTwo = new Random().nextInt(2) + 1;

			switch (oneOrTwo) {
				case 1:
					return character1;
				case 2:
					return character2;
			}
		} else if (character1.isDead()) {
			return character2;
		} else if (character2.isDead()) {
			return character1;
		}

		// 基本的にどちらとも死んでいることはあり得ない想定
		return null;
	}

	private void fireBall(Character character) {

		System.out.println("マリオはファイヤ・ボールを繰り出した！！");
		System.out.println(character.getNamae() + "に150のダメージ");

		character.setHp(150);

		if (character.isDead()) {
			try {
				Thread.sleep(1400);
			} catch (InterruptedException g) {
				// NOP
			}

			System.out.println(character.getNamae() + "は息絶えた。。。");
		}
	}

	private void throwShell(Character character) {
		System.out.println("マリオは甲羅を投げつけた！！！");
		System.out.println(character.getNamae() + "に200のダメージ");

		character.setHp(200);

		if (character.isDead()) {
			try {
				Thread.sleep(1400);
			} catch (InterruptedException g) {
				// NOP
			}
			System.out.println(character.getNamae() + "は息絶えた。。。");
		}
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int h) {
		this.hp -= h;

		if (this.hp < 0) {
			this.hp = 0; //hpはゼロ以下にはならない
		}
	}

	public boolean isSurviving() {
		return !isDead();
	}

	public boolean isDead() {
		return this.hp == 0;
	}
}