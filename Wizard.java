public class Wizard implements Character
{
	private int hp = 800;
	private int mp = 0;//�K�E�Z��3���܂�Ǝg����
	private String namae = "���@�g��";


	public int selectAttack()
	{
		int input = 0;
		if (this.mp < 3)
		{
			boolean correct = true;
			do
			{
				System.out.println("���@�g���̍U����I��");
				System.out.println("��ł��������P�@�W�����遨�Q : ");
				input = new java.util.Scanner(System.in).nextInt();

				if (input == 1 || input == 2)
					correct = false;
			}while (correct);
		}
		if (this.mp >= 3)
		{
			System.out.println("���@�g���̍U����I��");
			System.out.println("��ł��������P�@�W�����遨�Q ����������R : ");
			input = new java.util.Scanner(System.in).nextInt();
			
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
		}
	}

	public void attack1(Mario mar)
	{
		System.out.println("���@�g���͏�ōU���I");
		System.out.println("�}���I��50�̃_���[�W");
		mar.setHp(50);
	}

	public void attack2(Mario mar)
	{
		System.out.println("���@�g���͏��Ɉӎ����W���������B");

		if (this.mp < 2)
		{
			this.mp++;
			System.out.println("�������Ə��ɗ͂����܂��Ă��Ă���B�B");
		}
		else if (this.mp == 2)
		{
			this.mp++;
			System.out.println("��悪����������n�߂��I�I�I");
		}
		else if (this.mp > 2)
			System.out.println("���͂��łɌ����Ă���B");
	}

	public void specialAttack(Mario mar)
	{
		this.mp = 0;
		int damage = 0;
		System.out.println("���@�g���͌�����������I�I");
		System.out.println("�����͑唚�����N�������I�I�I");
		int r = new java.util.Random().nextInt(3) + 1;
		switch (r)
		{
			case 1:
				damage = 620;
				break;
			case 2:
				damage = 680;
				break;
			case 3:
				damage = 720;
		}
		System.out.println("�}���I��" + damage + "�̃_���[�W");
		mar.setHp(damage);
	}

	public int getHp()
	{
		return this.hp;
	}

	public void setHp(int h)
	{
		this.hp -= h;

		if (this.hp < 0)
			this.hp = 0;
		if (this.hp > 800)
			this.hp = 800;
	}

	public String getNamae()
	{
		return this.namae;
	}
}