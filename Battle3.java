//�N���X�A�C���X�^���X������̘b�͎��ۂɃv���O���������Ȃ���
//�s���Ƃ��Ȃ��̂ŁA�ȉ��Ńo�g���E�v���O�������쐬����B

//�N���X�͐_�l�̃N���X�A�}���I�̃N���X�A�G�r�����[�̃N���X�̂R�ō���Ă݂�
//�����āA�}���I�ƃG�r�����[���C���X�^���X�����A�_�l�̃N���X��ő��삷��B

public class Battle3 extends Thread
{

	public static void main(String[] args)
	{
		int chooseCharacter1 = 0;
		int chooseCharacter2 = 0;

		Character c1;
		Character c2;

		boolean correct = true;

		System.out.println("\n�g�p�L�����N�^�[��2�̑I��");
		
		do
		{
			System.out.println("�y�L�����N�^�[No.1�z");
			System.out.print("�G�r�����[���P�@���@�g�����Q�@���n�l���R �t�N���E���S: ");
			chooseCharacter1 = new java.util.Scanner(System.in).nextInt();

			if (chooseCharacter1 < 1 || chooseCharacter1 > 4)
				correct = false;
			else
				correct = true;
		}while (!(correct));

		do
		{
			System.out.println("�y�L�����N�^�[No.2�z");
			System.out.print("�G�r�����[���P�@���@�g�����Q�@���n�l���R �t�N���E���S: ");
			chooseCharacter2 = new java.util.Scanner(System.in).nextInt();

			if (chooseCharacter2 < 1 || chooseCharacter2 > 4)
				correct = false;
			else if (chooseCharacter1 == chooseCharacter2)
			{	
				correct = false;
				System.out.println("\n�����L�����N�^�[�͎g�p�ł��܂���B�B\n");
			}
			else
				correct = true;
		}while (!(correct));


//�I�������L�����N�^�[�̃C���X�^���X���쐬

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

		System.out.println("\n�G�̃}���I�����ꂽ�I�I�I");


		while (!(c1.getHp() <= 0 && c2.getHp() <= 0) || (m.getHp() <= 0))//��������������i�����҂Ƃ������Ă������j�ȉ��̃��[�v���J��Ԃ�
		{

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("�}���IHP�F" + m.getHp() + "\n");
			System.out.println(c1.getNamae() + "HP�F" + c1.getHp() + "  " + c2.getNamae() + "HP�F" + c2.getHp());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			int x = 0;//c1�̑I�����ꂽ�U���̔ԍ�������ϐ�
			int y = 0;//c2�̑I�����ꂽ�U���̔ԍ�������ϐ�

			if (c1.getHp() > 0)
			{
				x = c1.selectAttack();//x�ɂ�1~3(Ebiwara�͂S��)�̂����ꂩ������
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
				m.fireBall(c1);//m�i�}���I�j�̍U���������o���Ae�i�G�r�����[�j�Ƀ_���[�W��^����Ƃ����ꕶ
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
			System.out.println("�}���IHP�F" + m.getHp() + "\n");
			System.out.println(c1.getNamae() + "HP�F" + c1.getHp() + "  " + c2.getNamae() + "HP�F" + c2.getHp());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");




		//��̃��[�v�̎d�g�݂ɂ��A�ȉ��Q��if�\���̂����A�K���P���������s�����B

		if (m.getHp() == 0)
			System.out.println(c1.getNamae() + "&" + c2.getNamae() + "�̃`�[���̏����I");
		if (c1.getHp() == 0 && c2.getHp() == 0)
			System.out.println("�}���I�̏����I");
		
	}

}