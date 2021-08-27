public class Mario
{
	//まずは、インスタンスが保有するべき情報をフィールドで宣言

	private int hp = 3000;//他のクラスからこの値を変えられないようになっている

	public void fireBall(Character car)
	{

		System.out.println("マリオはファイヤ・ボールを繰り出した！！");
		System.out.println(car.getNamae() + "に150のダメージ");

		car.setHp(150);

		if (car.getHp() == 0)
		{
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException g)
			{}
			System.out.println(car.getNamae() + "は息絶えた。。。");
			
		}


	}

	public void throwShell(Character car)
	{
		System.out.println("マリオは甲羅を投げつけた！！！");
		System.out.println(car.getNamae() + "に200のダメージ");

		car.setHp(200);

		if (car.getHp() == 0)
		{
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException g)
			{}
			System.out.println(car.getNamae() + "は息絶えた。。。");
			
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
}