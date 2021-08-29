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

		Character character1;
		Character character2;

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
				character1 = new Ebiwara();
				break;
			case 2:
				character1 = new Wizard();
				break;
			case 3:
				character1 = new PrimitiveMan();
				break;
			case 4:
				character1 = new Owl();
				break;
			default:
				character1 = new Ebiwara();
		}

		switch (chooseCharacter2)
		{
			case 1:
				character2 = new Ebiwara();
				break;
			case 2:
				character2 = new Wizard();
				break;
			case 3:
				character2 = new PrimitiveMan();
				break;
			case 4:
				character2 = new Owl();
				break;
			default:
				character2 = new Ebiwara();
		}


		Mario mario = new Mario();

		System.out.println("\n敵のマリオが現れた！！！");


		while (!(character1.getHp() <= 0 && character2.getHp() <= 0) || (mario.getHp() <= 0))//勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す
		{

			showStatus(mario, character1, character2);
			
			int x = 0;//character1の選択された攻撃の番号を入れる変数
			int y = 0;//character2の選択された攻撃の番号を入れる変数

			if (character1.getHp() > 0)
			{
				x = character1.selectAttack();//xには1~3(Ebiwaraは４も)のいずれかが入る
				System.out.println(" ");
			}
			if (character2.getHp() > 0)
			{
				y = character2.selectAttack();
				System.out.println(" ");
			}

			try
			{
				Thread.sleep(800);
			}
			catch (InterruptedException g)
			{}

			if (character1.getHp() > 0)
			{
				character1.callAttack(x, mario, character1, character2);
				System.out.println(" ");

				try
				{
					Thread.sleep(1400);
				}
				catch (InterruptedException g)
				{}
			}

			if (character2.getHp() > 0)
			{
				character2.callAttack(y, mario, character1, character2);
				System.out.println(" ");


				try
				{
					Thread.sleep(1400);
				}
				catch (InterruptedException g)
				{}
			}

			if (mario.getHp() == 0)
				break;

			int r = 0;

			if (character1.getHp() > 0 && character2.getHp() > 0)
				r = new java.util.Random().nextInt(4) + 1;

			if (character1.getHp() == 0)
				r = new java.util.Random().nextInt(2) + 3;

			if (character2.getHp() == 0)
				r = new java.util.Random().nextInt(2) + 1;
				

			if (r == 1)
				mario.fireBall(character1);//m（マリオ）の攻撃を引き出し、e（エビワラー）にダメージを与えるという一文
			if (r == 2)
				mario.throwShell(character1);
			if (r == 3)
				mario.fireBall(character2);
			if (r == 4)
				mario.throwShell(character2);
			System.out.println(" ");


			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException g)
			{}

		}

		showStatus(mario, character1, character2);

		//上のループの仕組みにより、以下２つのif構文のうち、必ず１つだけが実行される。

		if (mario.getHp() == 0)
			System.out.println(character1.getNamae() + "&" + character2.getNamae() + "のチームの勝ち！");
		if (character1.getHp() == 0 && character2.getHp() == 0)
			System.out.println("マリオの勝ち！");
		
	}

	private static void showStatus(Mario mario, Character character1, Character character2) {

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("マリオHP：" + mario.getHp() + "\n");
		System.out.print(character1.getNamae() + "HP：" + character1.getHp() + "  ");
		System.out.println(character2.getNamae() + "HP：" + character2.getHp());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");	
	}

}