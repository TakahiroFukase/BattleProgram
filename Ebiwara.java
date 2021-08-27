import javax.swing.JOptionPane;
	


public class Ebiwara extends Thread implements Character
{
	private int hp = 1000;//他のクラスからこの値を変えられないようになっている

	private String namae = "エビワラー";

	private boolean anounce = true;


	public int selectAttack()
	{
		System.out.println("エビワラーの攻撃を選択");
		int input = 0;
		
		if (this.hp >= 500)
		{

				System.out.print("ファイア・パンチ→１　かみなりパンチ→２ : ");
				input = new java.util.Scanner(System.in).nextInt();
				if (!(input == 1 || input == 2))
				{
					input = 4;
				}

		}
		else
		{
			System.out.print("ファイア・パンチ→１　かみなりパンチ→２　連続パンチ→３ : ");
			input = new java.util.Scanner(System.in).nextInt();
			if (! (input == 1 || input == 2 || input == 3))
			{
				input = 4;
			}
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
				break;
			case 4:
				doNothing();
		}
	}


	public void attack1(Mario mar)
	{
		int damage = 0;
		System.out.println("エビワラーのファイア・パンチ！！！");

		int r = new java.util.Random().nextInt(50) + 1;
		damage = 120 + r;
		System.out.println("マリオに" + damage + "のダメージ");
		mar.setHp(damage);//ここでMarioのsetterから、Marioのhpにアクセスする
	}


	public void attack2(Mario mar)
	{

		int damage = 0;
		System.out.println("エビワラーのかみなりパンチ！！！");
		int r = new java.util.Random().nextInt(2) + 1;
		switch (r)
		{
			case 1:
				damage = 50;
				break;
			case 2:
				damage = 250;
				break;
		}
		System.out.println("マリオに" + damage + "のダメージ");
		mar.setHp(damage);
	}


	public void specialAttack(Mario mar)
	{
		int damage = 0;
		System.out.println("エビワラーは連続パンチを繰り出した！");
		for(int i = 3; i > 0; i--)
		{
			System.out.println(i);
			try
			{
				Thread.sleep(700);
			}
			catch (InterruptedException g)
			{}			
		}
		int r = new java.util.Random().nextInt(3) + 1;
		String input = "";
		String word = "";

		switch (r)
		{
			case 1:
				word = "coffee";
				break;
			case 2:
				word = "television";
				break;
			case 3:
				word = "somewhere";
		}

		long start = System.currentTimeMillis();

		input = JOptionPane.showInputDialog(word);
		long end = System.currentTimeMillis();
		long duration = ((end - start) / 1000);
		boolean hit = false;

		if (input.equals(word))
			hit = true;

		if (hit)
		{
			if (duration < 2)
				{
					damage = 350;
					System.out.println("パンチは7回ヒットした！！！");
					System.out.println("マリオに" + damage + "のダメージ");
				}
				else if (duration < 4)
				{
					damage = 300;
					System.out.println("パンチは5回ヒットした！！！");
					System.out.println("マリオに" + damage + "のダメージ");
				}
			else
				{
					damage = 150;
					System.out.println("パンチは3回しかヒットしなかった。");
					System.out.println("マリオに" + damage + "のダメージ");
				}
		}
		else
			System.out.println("攻撃は外れた、、、");

		mar.setHp(damage);

	}

	public void doNothing()
	{
		System.out.println("エビワラーはぼーっとしている、、、");

	}



	public int getHp()
	{
		return this.hp;
	}

	public void setHp(int h)//これがEbiwaraのhpを操るためのsetterである
	{
		this.hp -= h;

		if (this.hp < 0)//hpはゼロ以下にはならない
			this.hp = 0;
		if (this.hp > 1000)
			this.hp = 1000;
		if (this.hp < 500 && this.anounce)
		{
			System.out.println("\nエビワラーは「怒り状態」になった！！！");
			this.anounce = false;
		}
		if (this.hp >= 500 && (!(this.anounce)))
		{
			System.out.println("\nエビワラーの「怒り状態」はおさまった。");
			this.anounce = true;
		}
	}

	public String getNamae()
	{
		return this.namae;
	}
}