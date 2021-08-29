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

		println("\n使用キャラクターを2体選択");
		
		do
		{
			println("【キャラクターNo.1】");
			print("エビワラー→１　魔法使い→２　原始人→３ フクロウ→４: ");
			chooseCharacter1 = new java.util.Scanner(System.in).nextInt();

			if (chooseCharacter1 < 1 || chooseCharacter1 > 4)
				correct = false;
			else
				correct = true;
		}while (!(correct));

		do
		{
			println("【キャラクターNo.2】");
			print("エビワラー→１　魔法使い→２　原始人→３ フクロウ→４: ");
			chooseCharacter2 = new java.util.Scanner(System.in).nextInt();

			if (chooseCharacter2 < 1 || chooseCharacter2 > 4)
				correct = false;
			else if (chooseCharacter1 == chooseCharacter2)
			{	
				correct = false;
				println("\n同じキャラクターは使用できません。。\n");
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

		println("\n敵のマリオが現れた！！！");


		while (!(character1.getHp() <= 0 && character2.getHp() <= 0) || (mario.getHp() <= 0))//勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す
		{

			showStatus(mario, character1, character2);
			
			int attackNoForCharacter1 = 0;
			int attackNoForCharacter2 = 0;

			if (character1.getHp() > 0)
			{
				attackNoForCharacter1 = character1.selectAttack();
				breakLine();
			}
			if (character2.getHp() > 0)
			{
				attackNoForCharacter2 = character2.selectAttack();
				breakLine();
			}

			sleep(800);

			if (character1.getHp() > 0)
			{
				character1.callAttack(attackNoForCharacter1, mario, character1, character2);
				breakLine();

				sleep(1400);
			}

			if (character2.getHp() > 0)
			{
				character2.callAttack(attackNoForCharacter2, mario, character1, character2);
				breakLine();


				sleep(1400);
			}

			if (mario.getHp() == 0)
				break;

			int r = 0;

			if (character1.getHp() > 0 && character2.getHp() > 0)
			{
				int oneOrTwo = new java.util.Random().nextInt(2) + 1;

				switch (oneOrTwo)
				{
					case 1:
						mario.callAttack(character1);
						break;
					case 2:
						mario.callAttack(character2);
						break;
				}
			}
			else if (character1.getHp() == 0)
			{
				mario.callAttack(character2);
			}
			else if (character2.getHp() == 0) 
			{
				mario.callAttack(character1);
			}
			
			breakLine();


			sleep(2000);

		}

		showStatus(mario, character1, character2);

		//上のループの仕組みにより、以下２つのif構文のうち、必ず１つだけが実行される。

		if (mario.getHp() == 0)
			println(character1.getNamae() + "&" + character2.getNamae() + "のチームの勝ち！");
		if (character1.getHp() == 0 && character2.getHp() == 0)
			println("マリオの勝ち！");
		
	}

	private static void print(String text) {
		System.out.print(text);
	}

	private static void println(String text) {
		System.out.println(text);
	}

	private static void breakLine() {
		println(" ");
	}

	public static void sleep(long millis) {
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException g)
		{}
	}

	private static void showStatus(Mario mario, Character character1, Character character2) {

		println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		println("マリオHP：" + mario.getHp() + "\n");
		print(character1.getNamae() + "HP：" + character1.getHp() + "  ");
		println(character2.getNamae() + "HP：" + character2.getHp());
		println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");	
	}

}