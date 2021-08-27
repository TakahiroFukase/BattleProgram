import javax.swing.JOptionPane;
	


public class Ebiwara extends Thread implements Character
{
	private int hp = 1000;//���̃N���X���炱�̒l��ς����Ȃ��悤�ɂȂ��Ă���

	private String namae = "�G�r�����[";

	private boolean anounce = true;


	public int selectAttack()
	{
		System.out.println("�G�r�����[�̍U����I��");
		int input = 0;
		
		if (this.hp >= 500)
		{

				System.out.print("�t�@�C�A�E�p���`���P�@���݂Ȃ�p���`���Q : ");
				input = new java.util.Scanner(System.in).nextInt();
				if (!(input == 1 || input == 2))
				{
					input = 4;
				}

		}
		else
		{
			System.out.print("�t�@�C�A�E�p���`���P�@���݂Ȃ�p���`���Q�@�A���p���`���R : ");
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
		System.out.println("�G�r�����[�̃t�@�C�A�E�p���`�I�I�I");

		int r = new java.util.Random().nextInt(50) + 1;
		damage = 120 + r;
		System.out.println("�}���I��" + damage + "�̃_���[�W");
		mar.setHp(damage);//������Mario��setter����AMario��hp�ɃA�N�Z�X����
	}


	public void attack2(Mario mar)
	{

		int damage = 0;
		System.out.println("�G�r�����[�̂��݂Ȃ�p���`�I�I�I");
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
		System.out.println("�}���I��" + damage + "�̃_���[�W");
		mar.setHp(damage);
	}


	public void specialAttack(Mario mar)
	{
		int damage = 0;
		System.out.println("�G�r�����[�͘A���p���`���J��o�����I");
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
					System.out.println("�p���`��7��q�b�g�����I�I�I");
					System.out.println("�}���I��" + damage + "�̃_���[�W");
				}
				else if (duration < 4)
				{
					damage = 300;
					System.out.println("�p���`��5��q�b�g�����I�I�I");
					System.out.println("�}���I��" + damage + "�̃_���[�W");
				}
			else
				{
					damage = 150;
					System.out.println("�p���`��3�񂵂��q�b�g���Ȃ������B");
					System.out.println("�}���I��" + damage + "�̃_���[�W");
				}
		}
		else
			System.out.println("�U���͊O�ꂽ�A�A�A");

		mar.setHp(damage);

	}

	public void doNothing()
	{
		System.out.println("�G�r�����[�͂ځ[���Ƃ��Ă���A�A�A");

	}



	public int getHp()
	{
		return this.hp;
	}

	public void setHp(int h)//���ꂪEbiwara��hp�𑀂邽�߂�setter�ł���
	{
		this.hp -= h;

		if (this.hp < 0)//hp�̓[���ȉ��ɂ͂Ȃ�Ȃ�
			this.hp = 0;
		if (this.hp > 1000)
			this.hp = 1000;
		if (this.hp < 500 && this.anounce)
		{
			System.out.println("\n�G�r�����[�́u�{���ԁv�ɂȂ����I�I�I");
			this.anounce = false;
		}
		if (this.hp >= 500 && (!(this.anounce)))
		{
			System.out.println("\n�G�r�����[�́u�{���ԁv�͂����܂����B");
			this.anounce = true;
		}
	}

	public String getNamae()
	{
		return this.namae;
	}
}