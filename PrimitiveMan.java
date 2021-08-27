public class PrimitiveMan implements Character
{
	private int hp = 1000;

	private String namae = "���n�l";


	public int selectAttack()
	{
		boolean correct = true;
		int input = 0;
		do
		{
			System.out.println("���n�l�̍U����I��");
			System.out.println("�u�[�������U�����P�@�΂𓊂��遨�Q�@����_�Œ@�����R : ");
			input = new java.util.Scanner(System.in).nextInt();

			if (input < 1 || input > 3)
				correct = false;
			else
				correct = true;
		}while (!(correct));

		return input;
	}

	public void callAttack(int i, Mario mar, Character c1, Character c2)
	{
		switch (i)
		{
			case 1 :
				attack1(mar);
				break;
			case 2:
				attack2(mar);
				break;
			case 3:
				specialAttack(mar);//���n�l�̏ꍇ�͂�������ʂ̍U��
		}
	}

	public void attack1(Mario mar)
	{
		int damage = 0;

		System.out.println("���n�l�̃u�[�������U���I�I");

		int r = new java.util.Random().nextInt(5) + 1;
		switch (r)
		{
			case 1:
			case 2:
			case 3:
				System.out.println("�������U���͂͂��ꂽ�B�B");
				break;
			case 4:
				System.out.println("�}���I��100�̃_���[�W�I");
				damage = 100;
				break;
			case 5:
				System.out.println("�U���͓G�̊�ʂɖ����I�I�I�I");
				System.out.println("�}���I��350�̃_���[�W�I");
				damage = 350;
		}
		mar.setHp(damage);
	}

	public void attack2(Mario mar)
	{
		int r = new java.util.Random().nextInt(5) + 1;
		int damage = 50 * r;

		System.out.println("���n�l�͐΂𓊂������I");
		System.out.println("�΂�" + r + "���������I");
		System.out.println("�}���I��" + damage + "�̃_���[�W�I�I");

		mar.setHp(damage);
	}

	public void specialAttack(Mario mar)
	{
		System.out.println("���n�l�͂���_�ōU���I");
		System.out.println("�}���I��100�̃_���[�W�I");

		mar.setHp(100);
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
		if (this.hp > 1000)
			this.hp = 1000;
	}

	public String getNamae()
	{
		return this.namae;
	}

}