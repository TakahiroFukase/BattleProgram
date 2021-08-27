//クラス、インスタンスあたりの話は実際にプログラムを作らないと
//ピンとこないので、以下でバトル・プログラムを作成する。

//クラスは神様のクラス、マリオのクラス、エビワラーのクラスの３つで作ってみる
//そして、マリオとエビワラーをインスタンス化し、神様のクラス上で操作する。

public class Battle3 extends Thread
{

	public static void main(String[] args)
	{
		int chooseCharacter1 = 0;
		int chooseCharacter2 = 0;

		Character c1;
		Character c2;

		boolean correct = true;

		System.out.println("\n使用キャラクターを2体選択");
		
		do
		{
			System.out.println("【キャラクターNo.1】");
			System.out.print("エビワラー→１　魔法使い→２　原始人→３ フクロウ→４: ");
			chooseCharacter1 = new java.util.Scanner(System.in).nextInt();

			if (chooseCharacter1 < 1 || chooseCharacter1 > 4)
				correct = false;
			else
				correct = true;
		}while (!(correct));

		do
		{
			System.out.println("【キャラクターNo.2】");
			System.out.print("エビワラー→１　魔法使い→２　原始人→３ フクロウ→４: ");
			chooseCharacter2 = new java.util.Scanner(System.in).nextInt();

			if (chooseCharacter2 < 1 || chooseCharacter2 > 4)
				correct = false;
			else if (chooseCharacter1 == chooseCharacter2)
			{	
				correct = false;
				System.out.println("\n同じキャラクターは使用できません。。\n");
			}
			else
				correct = true;
		}while (!(correct));


//選択したキャラクターのインスタンスを作成

		switch (chooseCharacter1)
		{
			case 1:
				c1 = new Ebiwara();
				break;
			case 2:
				c1 = new Wizard();
				break;
			case 3:
				c1 = new PrimitiveMan();
				break;
			case 4:
				c1 = new Owl();
				break;
			default:
				c1 = new Ebiwara();
		}

		switch (chooseCharacter2)
		{
			case 1:
				c2 = new Ebiwara();
				break;
			case 2:
				c2 = new Wizard();
				break;
			case 3:
				c2 = new PrimitiveMan();
				break;
			case 4:
				c2 = new Owl();
				break;
			default:
				c2 = new Ebiwara();
		}


		Mario m = new Mario();

		System.out.println("\n敵のマリオが現れた！！！");


		while (!(c1.getHp() <= 0 && c2.getHp() <= 0) || (m.getHp() <= 0))//勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す
		{

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("マリオHP：" + m.getHp() + "\n");
			System.out.println(c1.getNamae() + "HP：" + c1.getHp() + "  " + c2.getNamae() + "HP：" + c2.getHp());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			int x = 0;//c1の選択された攻撃の番号を入れる変数
			int y = 0;//c2の選択された攻撃の番号を入れる変数

			if (c1.getHp() > 0)
			{
				x = c1.selectAttack();//xには1~3(Ebiwaraは４も)のいずれかが入る
				System.out.println(" ");
			}
			if (c2.getHp() > 0)
			{
				y = c2.selectAttack();
				System.out.println(" ");
			}

			try
			{
				Thread.sleep(800);
			}
			catch (InterruptedException g)
			{}

			if (c1.getHp() > 0)
			{
				c1.callAttack(x, m, c1, c2);
				System.out.println(" ");

				try
				{
					Thread.sleep(1400);
				}
				catch (InterruptedException g)
				{}
			}

			if (c2.getHp() > 0)
			{
				c2.callAttack(y, m, c1, c2);
				System.out.println(" ");


				try
				{
					Thread.sleep(1400);
				}
				catch (InterruptedException g)
				{}
			}

			if (m.getHp() == 0)
				break;

			int r = 0;

			if (c1.getHp() > 0 && c2.getHp() > 0)
				r = new java.util.Random().nextInt(4) + 1;

			if (c1.getHp() == 0)
				r = new java.util.Random().nextInt(2) + 3;

			if (c2.getHp() == 0)
				r = new java.util.Random().nextInt(2) + 1;
				

			if (r == 1)
				m.fireBall(c1);//m（マリオ）の攻撃を引き出し、e（エビワラー）にダメージを与えるという一文
			if (r == 2)
				m.throwShell(c1);
			if (r == 3)
				m.fireBall(c2);
			if (r == 4)
				m.throwShell(c2);
			System.out.println(" ");


			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException g)
			{}

		}

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("マリオHP：" + m.getHp() + "\n");
			System.out.println(c1.getNamae() + "HP：" + c1.getHp() + "  " + c2.getNamae() + "HP：" + c2.getHp());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");




		//上のループの仕組みにより、以下２つのif構文のうち、必ず１つだけが実行される。

		if (m.getHp() == 0)
			System.out.println(c1.getNamae() + "&" + c2.getNamae() + "のチームの勝ち！");
		if (c1.getHp() == 0 && c2.getHp() == 0)
			System.out.println("マリオの勝ち！");
		
	}

}