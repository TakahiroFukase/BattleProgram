import javax.swing.JOptionPane;
	


public class Owl extends Thread implements Character
{
	private int hp = 800;//���̃N���X���炱�̒l��ς����Ȃ��悤�ɂȂ��Ă���

	private String namae = "�t�N���E";


	public int selectAttack()
	{
		System.out.println("�t�N���E�̍U����I��");
		int input = 0;

		do
		{
			System.out.print("�₽�������P�@���Ԃ��Ăԁ��Q �����̕����R: ");
			input = new java.util.Scanner(System.in).nextInt();
		}while (input < 1 || input > 3);
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
				specialAttack(c1, c2);
		}
	}


	public void attack1(Mario mar)
	{
		System.out.println("�t�N���E�͗₽�����������N�������I");
		int r = new java.util.Random().nextInt(20) + 1;
		int damage = 100 + r;
		System.out.println("�}���I��" + damage + "�̃_���[�W");

		mar.setHp(damage);//������Mario��setter����AMario��hp�ɃA�N�Z�X����
	}


	public void attack2(Mario mar)
	{

		int damage = 0;
		System.out.println("�t�N���E�͒��Ԃ��Ă񂾁I�I�I");
		int r = new java.util.Random().nextInt(5) + 1;
		try
		{
			Thread.sleep(1900);
		}
		catch (InterruptedException g)
		{}			

		switch (r)
		{
			case 1:
			case 2:
				System.out.println("�������Ăѐ��͂Ƃǂ��Ȃ������B�B");
				break;
			case 3:
				System.out.println("���Ԃ̃t�N���E�P�H���}���I�ɓːi�����I�I");
				damage = 150;
				System.out.println("�}���I��" + damage + "�̃_���[�W");
				break;
			case 4:
			case 5:
				System.out.println("���Ԃ̃t�N���E�Q�H���}���I�ɓːi�����I�I");
				damage = 250;
				System.out.println("�}���I��" + damage + "�̃_���[�W");
		}
		mar.setHp(damage);
	}

	public void specialAttack(Mario Mar)
	{}

	public void specialAttack(Character c1, Character c2)
	{

		int r = new java.util.Random().nextInt(50) + 1;

		int recover1 = (30 + r);

		int r2 = new java.util.Random().nextInt(50) + 1;

		int recover2 = (30 + r2);

		System.out.println("�t�N���E�͖����̕��������N�������I�I");
		try
		{
			Thread.sleep(1900);
		}
		catch (InterruptedException g)
		{}			

		System.out.println(c1.getNamae() + "��HP��" + recover1 + "�񕜂����I�I");
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException g)
		{}	
		System.out.println(c2.getNamae() + "��HP��" + recover2 + "�񕜂����I�I");

		c1.setHp((-1) * recover1);
		c2.setHp((-1) * recover2);
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
		if (this.hp > 800)
			this.hp = 800;
	}

	public String getNamae()
	{
		return this.namae;
	}
}