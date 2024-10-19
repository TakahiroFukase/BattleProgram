import java.util.*;
import javax.swing.JOptionPane;
	
public class Owl extends Thread implements Character {

	private int hp = 800; //他のクラスからこの値を変えられないようになっている

	private String namae = "フクロウ";

	private int selectedAttackNumber = 0;

	public void selectAttack() {
		
		System.out.println("フクロウの攻撃を選択");

		int input = 0;

		do {
			System.out.print("冷たい風→１　仲間を呼ぶ→２ 癒しの風→３: ");
			input = new Scanner(System.in).nextInt();
		} while (input < 1 || input > 3);
		
		selectedAttackNumber = input;
	}

	public void callAttack(Mario mar, Character c1, Character c2) {
		switch (selectedAttackNumber) {
			case 1:
				attack1(mar);
				break;
			case 2:
				attack2(mar);
				break;
			case 3:
				specialAttack(c1, c2);
		}

		selectedAttackNumber = 0;
	}

	public void attack1(Mario mar) {
		System.out.println("フクロウは冷たい風を巻き起こした！");
		int r = new Random().nextInt(20) + 1;
		int damage = 100 + r;
		System.out.println("マリオに" + damage + "のダメージ");

		mar.setHp(damage); //ここでMarioのsetterから、Marioのhpにアクセスする
	}

	public void attack2(Mario mar) {

		int damage = 0;
		System.out.println("フクロウは仲間を呼んだ！！！");
		int r = new Random().nextInt(5) + 1;
		
		Util.sleep(1900);		

		switch (r) {
			case 1:
			case 2:
				System.out.println("しかし呼び声はとどかなかった。。");
				break;
			case 3:
				System.out.println("仲間のフクロウ１羽がマリオに突進した！！");
				damage = 150;
				System.out.println("マリオに" + damage + "のダメージ");
				break;
			case 4:
			case 5:
				System.out.println("仲間のフクロウ２羽がマリオに突進した！！");
				damage = 250;
				System.out.println("マリオに" + damage + "のダメージ");
		}
		mar.setHp(damage);
	}

	public void specialAttack(Mario Mar) {}

	public void specialAttack(Character c1, Character c2) {

		int r = new Random().nextInt(50) + 1;

		int recover1 = (30 + r);

		int r2 = new Random().nextInt(50) + 1;

		int recover2 = (30 + r2);

		System.out.println("フクロウは癒しの風を巻き起こした！！");

		Util.sleep(1900);		

		System.out.println(c1.getNamae() + "のHPが" + recover1 + "回復した！！");
		
		Util.sleep(1000);

		System.out.println(c2.getNamae() + "のHPが" + recover2 + "回復した！！");

		c1.setHp((-1) * recover1);
		c2.setHp((-1) * recover2);
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int h) { //これがEbiwaraのhpを操るためのsetterである
		this.hp -= h;

		if (this.hp < 0) {//hpはゼロ以下にはならない
			this.hp = 0;
		}
		
		if (this.hp > 800) {
			this.hp = 800;
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