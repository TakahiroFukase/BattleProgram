//�N���X�A�C���X�^���X������̘b�͎��ۂɃv���O���������Ȃ���
//�s���Ƃ��Ȃ��̂ŁA�ȉ��Ńo�g���E�v���O�������쐬����B

//�N���X�͐_�l�̃N���X�A�}���I�̃N���X�A�G�r�����[�̃N���X�̂R�ō���Ă݂�
//�����āA�}���I�ƃG�r�����[���C���X�^���X�����A�_�l�̃N���X��ő��삷��B

public class Battle2 extends Thread
{

	public static void main(String[] args)
	{
		System.out.println("�G�̃}���I�����ꂽ�I");


		System.out.println("\n�g�p�L�����N�^�[��I��");
		System.out.print("�G�r�����[���P�@���@�g�����Q : ");
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


		while (c1.getHp() > 0 && m.getHp() > 0)//��������������i�����҂Ƃ������Ă������j�ȉ��̃��[�v���J��Ԃ�
		{

			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.print(c1.getNamae() + "HP�F" + c1.getHp() + "  ");
			System.out.println("�}���IHP�F" + m.getHp() + "\n\n");
			System.out.println("++++++++++++++++++++++++++++++++++++++");


			int x = c1.selectAttack();//x�ɂ�1~3�̂����ꂩ������
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
				m.fireBall(c1);//m�i�}���I�j�̍U���������o���Ae�i�G�r�����[�j�Ƀ_���[�W��^����Ƃ����ꕶ
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
		System.out.print(c1.getNamae() + "HP�F" + c1.getHp() + "  ");
		System.out.println("�}���IHP�F" + m.getHp() + "\n\n");
		System.out.println("++++++++++++++++++++++++++++++++++++++");


		//��̃��[�v�̎d�g�݂ɂ��A�ȉ��Q��if�\���̂����A�K���P���������s�����B

		if (m.getHp() == 0)
			System.out.println(c1.getNamae() + "�̏����I");
		if (c1.getHp() == 0)
			System.out.println("�}���I�̏����I");
		
	}

}