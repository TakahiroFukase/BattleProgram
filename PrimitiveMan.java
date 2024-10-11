import java.util.*;

public class PrimitiveMan implements Character {
	
	private int hp = 1000;

	private String namae = "原始人";

	private int selectedAttackNumber = 0;

	public void selectAttack() {

		boolean correct = true;
		int input = 0;
		
		do {
			System.out.println("原始人の攻撃を選択");
			System.out.println("ブーメラン攻撃→１　石を投げる→２　こん棒で叩く→３ : ");
			input = new Scanner(System.in).nextInt();

			if (input < 1 || input > 3) {
				correct = false;
			} else {
				correct = true;
			}
		} while (!(correct));

		selectedAttackNumber = input;
	}

	public void callAttack(Mario mar, Character c1, Character c2) {
		switch (selectedAttackNumber) {
			case 1 :
				attack1(mar);
				break;
			case 2:
				attack2(mar);
				break;
			case 3:
				specialAttack(mar);//原始人の場合はこれも普通の攻撃
		}

		selectedAttackNumber = 0;
	}

	public void attack1(Mario mar) {
		int damage = 0;

		System.out.println("原始人のブーメラン攻撃！！");

		int r = new Random().nextInt(5) + 1;
		
		switch (r) {
			case 1:
			case 2:
			case 3:
				System.out.println("しかし攻撃ははずれた。。");
				break;
			case 4:
				System.out.println("マリオに100のダメージ！");
				damage = 100;
				break;
			case 5:
				System.out.println("攻撃は敵の顔面に命中！！！！");
				System.out.println("マリオに350のダメージ！");
				damage = 350;
		}
		mar.setHp(damage);
	}

	public void attack2(Mario mar) {
		int r = new Random().nextInt(5) + 1;
		int damage = 50 * r;

		System.out.println("原始人は石を投げつけた！");
		System.out.println("石は" + r + "つ命中した！");
		System.out.println("マリオに" + damage + "のダメージ！！");

		mar.setHp(damage);
	}

	public void specialAttack(Mario mar) {
		System.out.println("原始人はこん棒で攻撃！");
		System.out.println("マリオに100のダメージ！");

		mar.setHp(100);
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int h) {
		this.hp -= h;

		if (this.hp < 0) {
			this.hp = 0;
		}

		if (this.hp > 1000) {
			this.hp = 1000;
		}
	}

	public String getNamae() {
		return this.namae;
	}

	public boolean isSurviving() {
		return !isDead();
	}

	public boolean isDead() {
		return this.hp == 0;
	}
}