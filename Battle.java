//クラス、インスタンスあたりの話は実際にプログラムを作らないと
//ピンとこないので、以下でバトル・プログラムを作成する。

//クラスは神様のクラス、マリオのクラス、エビワラーのクラスの３つで作ってみる
//そして、マリオとエビワラーをインスタンス化し、神様のクラス上で操作する。

public class Battle extends Thread
{

	public static void main(String[] args)
	{
		System.out.println("敵のマリオが現れた！");

		Ebiwara e = new Ebiwara();

		Mario m = new Mario();


		while (e.getHp() > 0 && m.getHp() > 0)//勝負が続く限り（＝両者とも生きている限り）以下のループを繰り返す
		{
			System.out.println("エビワラーの攻撃を選択");
			System.out.println("ファイア・パンチ→１　かみなりパンチ→２ れいとうパンチ→３ 連続パンチ→４ :");
			int input = new java.util.Scanner(System.in).nextInt();
			if (input == 1)
				e.firePunch(m);
			if (input == 2)
				e.thunderPunch(m);
			if (input == 3)
				e.icePunch(m);
			if (input == 4)
				e.renzokuPunch(m);
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
				m.fireBall(e);//m（マリオ）の攻撃を引き出し、e（エビワラー）にダメージを与えるという一文
			if (r == 2)
				m.throwShell(e);
			System.out.println(" ");


			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException g)
			{}


			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.print("エビワラーHP：" + e.getHp() + "  ");
			System.out.println("マリオHP：" + m.getHp() + "\n\n");
			System.out.println("++++++++++++++++++++++++++++++++++++++");

		}

		//上のループの仕組みにより、以下２つのif構文のうち、必ず１つだけが実行される。

		if (m.getHp() == 0)
		{
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.print("エビワラーHP：" + e.getHp() + "  ");
			System.out.println("マリオHP：" + m.getHp() + "\n\n");
			System.out.println("++++++++++++++++++++++++++++++++++++++");

			System.out.println("エビワラーの勝ち！");
		}
		if (e.getHp() == 0)
			System.out.println("マリオの勝ち！");
		
	}

}