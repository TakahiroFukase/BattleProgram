public class Mario
{
	//まずは、インスタンスが保有するべき情報をフィールドで宣言

	private int hp = 3000;//他のクラスからこの値を変えられないようになっている

	public void callAttack(Character character) {

		int oneOrTwo = new java.util.Random().nextInt(2) + 1;

		switch (oneOrTwo)
		{
			case 1:
				fireBall(character);
				break;
			case 2:
				throwShell(character);
				break;
		}
	}

	private void fireBall(Character character)
	{

		System.out.println("マリオはファイヤ・ボールを繰り出した！！");
		System.out.println(character.getNamae() + "に150のダメージ");

		character.setHp(150);

		if (character.getHp() == 0)
		{
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException g)
			{}
			System.out.println(character.getNamae() + "は息絶えた。。。");
			
		}


	}

	private void throwShell(Character character)
	{
		System.out.println("マリオは甲羅を投げつけた！！！");
		System.out.println(character.getNamae() + "に200のダメージ");

		character.setHp(200);

		if (character.getHp() == 0)
		{
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException g)
			{}
			System.out.println(character.getNamae() + "は息絶えた。。。");
			
		}

	}

	public int getHp()
	{

		return this.hp;
	}

	public void setHp(int h)
	{
		this.hp -= h;


		if (this.hp < 0)
			this.hp = 0;//hpはゼロ以下にはならない

	}

	public boolean isDead()
	{
		return this.hp == 0;
	}
}