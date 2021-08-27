//クラス、インスタンスあたりの話は実際にプログラムを作らないと
//ピンとこないので、以下でバトル・プログラムを作成する。

//クラスは神様のクラス、マリオのクラス、エビワラーのクラスの３つで作ってみる
//そして、マリオとエビワラーをインスタンス化し、神様のクラス上で操作する。

public class Battle2 extends Thread
{

	public static void main(String[] args)
	{
		System.out.println("敵のマリオが現れた！");


		System.out.println("\n使用キャラクターを選択");
		System.out.print("エビワラー→１　魔法使い→２ : ");
		int choice = 0;
		do
		{
			choice = new java.util.Scanner(System.in).nextInt();
		}while (!(choice == 1 || choice == 2));

		Character c1;

		if (choice == 1)
		{
			c1 = new Ebiwara();
		}
		else
		{
			c1 = new Wizard();
		}

		Mario m = new Mario();


		while (c1.getHp() > 0 && m.getHp() > 0)//勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す
		{

			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.print(c1.getNamae() + "HP：" + c1.getHp() + "  ");
			System.out.println("マリオHP：" + m.getHp() + "\n\n");
			System.out.println("++++++++++++++++++++++++++++++++++++++");


			int x = c1.selectAttack();//xには1~3のいずれかが入る
			c1.callAttack(x, m);
			System.out.println(" ");

			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException g)
			{}


			if (m.getHp() == 0)
				break;

			int r = new java.util.Random().nextInt(2) + 1;
			if (r == 1)
				m.fireBall(c1);//m（マリオ）の攻撃を引き出し、e（エビワラー）にダメージを与えるという一文
			if (r == 2)
				m.throwShell(c1);
			System.out.println(" ");


			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException g)
			{}

		}

		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print(c1.getNamae() + "HP：" + c1.getHp() + "  ");
		System.out.println("マリオHP：" + m.getHp() + "\n\n");
		System.out.println("++++++++++++++++++++++++++++++++++++++");


		//上のループの仕組みにより、以下２つのif構文のうち、必ず１つだけが実行される。

		if (m.getHp() == 0)
			System.out.println(c1.getNamae() + "の勝ち！");
		if (c1.getHp() == 0)
			System.out.println("マリオの勝ち！");
		
	}

}