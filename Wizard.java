public class Wizard implements Character
{
	private int hp = 800;
	private int mp = 0;//必殺技は3たまると使える
	private String namae = "魔法使い";


	public int selectAttack()
	{
		int input = 0;
		if (this.mp < 3)
		{
			boolean correct = true;
			do
			{
				System.out.println("魔法使いの攻撃を選択");
				System.out.println("杖でたたく→１　集中する→２ : ");
				input = new java.util.Scanner(System.in).nextInt();

				if (input == 1 || input == 2)
					correct = false;
			}while (correct);
		}
		if (this.mp >= 3)
		{
			System.out.println("魔法使いの攻撃を選択");
			System.out.println("杖でたたく→１　集中する→２ 光線を放つ→３ : ");
			input = new java.util.Scanner(System.in).nextInt();
			
		}
		return input;
	}

	public void callAttack(int i, Mario mar, Character c1, Character c2)
	{
		switch (i)
		{
			case 1:
				attack1(mar);
				break;
			case 2:
				attack2(mar);
				break;
			case 3:
				specialAttack(mar);
		}
	}

	public void attack1(Mario mar)
	{
		System.out.println("魔法使いは杖で攻撃！");
		System.out.println("マリオに50のダメージ");
		mar.setHp(50);
	}

	public void attack2(Mario mar)
	{
		System.out.println("魔法使いは杖先に意識を集中させた。");

		if (this.mp < 2)
		{
			this.mp++;
			System.out.println("ゆっくりと杖先に力がたまってきている。。");
		}
		else if (this.mp == 2)
		{
			this.mp++;
			System.out.println("杖先が激しく光り始めた！！！");
		}
		else if (this.mp > 2)
			System.out.println("杖先はすでに光っている。");
	}

	public void specialAttack(Mario mar)
	{
		this.mp = 0;
		int damage = 0;
		System.out.println("魔法使いは光線を放った！！");
		System.out.println("光線は大爆発を起こした！！！");
		int r = new java.util.Random().nextInt(3) + 1;
		switch (r)
		{
			case 1:
				damage = 620;
				break;
			case 2:
				damage = 680;
				break;
			case 3:
				damage = 720;
		}
		System.out.println("マリオに" + damage + "のダメージ");
		mar.setHp(damage);
	}

	public int getHp()
	{
		return this.hp;
	}

	public void setHp(int h)
	{
		this.hp -= h;

		if (this.hp < 0)
			this.hp = 0;
		if (this.hp > 800)
			this.hp = 800;
	}

	public String getNamae()
	{
		return this.namae;
	}
}