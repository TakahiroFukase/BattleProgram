//�N���X�A�C���X�^���X������̘b�͎��ۂɃv���O���������Ȃ���
//�s���Ƃ��Ȃ��̂ŁA�ȉ��Ńo�g���E�v���O�������쐬����B

//�N���X�͐_�l�̃N���X�A�}���I�̃N���X�A�G�r�����[�̃N���X�̂R�ō���Ă݂�
//�����āA�}���I�ƃG�r�����[���C���X�^���X�����A�_�l�̃N���X��ő��삷��B

public class Battle extends Thread
{

	public static void main(String[] args)
	{
		System.out.println("�G�̃}���I�����ꂽ�I");

		Ebiwara e = new Ebiwara();

		Mario m = new Mario();


		while (e.getHp() > 0 && m.getHp() > 0)//��������������i�����҂Ƃ������Ă������j�ȉ��̃��[�v���J��Ԃ�
		{
			System.out.println("�G�r�����[�̍U����I��");
			System.out.println("�t�@�C�A�E�p���`���P�@���݂Ȃ�p���`���Q �ꂢ�Ƃ��p���`���R �A���p���`���S :");
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
				m.fireBall(e);//m�i�}���I�j�̍U���������o���Ae�i�G�r�����[�j�Ƀ_���[�W��^����Ƃ����ꕶ
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
			System.out.print("�G�r�����[HP�F" + e.getHp() + "  ");
			System.out.println("�}���IHP�F" + m.getHp() + "\n\n");
			System.out.println("++++++++++++++++++++++++++++++++++++++");

		}

		//��̃��[�v�̎d�g�݂ɂ��A�ȉ��Q��if�\���̂����A�K���P���������s�����B

		if (m.getHp() == 0)
		{
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.print("�G�r�����[HP�F" + e.getHp() + "  ");
			System.out.println("�}���IHP�F" + m.getHp() + "\n\n");
			System.out.println("++++++++++++++++++++++++++++++++++++++");

			System.out.println("�G�r�����[�̏����I");
		}
		if (e.getHp() == 0)
			System.out.println("�}���I�̏����I");
		
	}

}