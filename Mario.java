public class Mario
{
	//�܂��́A�C���X�^���X���ۗL����ׂ������t�B�[���h�Ő錾

	private int hp = 3000;//���̃N���X���炱�̒l��ς����Ȃ��悤�ɂȂ��Ă���

	public void fireBall(Character car)
	{

		System.out.println("�}���I�̓t�@�C���E�{�[�����J��o�����I�I");
		System.out.println(car.getNamae() + "��150�̃_���[�W");

		car.setHp(150);

		if (car.getHp() == 0)
		{
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException g)
			{}
			System.out.println(car.getNamae() + "�͑��₦���B�B�B");
			
		}


	}

	public void throwShell(Character car)
	{
		System.out.println("�}���I�͍b���𓊂������I�I�I");
		System.out.println(car.getNamae() + "��200�̃_���[�W");

		car.setHp(200);

		if (car.getHp() == 0)
		{
			try
			{
				Thread.sleep(1400);
			}
			catch (InterruptedException g)
			{}
			System.out.println(car.getNamae() + "�͑��₦���B�B�B");
			
		}

	}

	public int getHp()
	{

		return this.hp;
	}

	public void setHp(int h)
	{
		this.hp -= h;


		if (this.hp < 0)
			this.hp = 0;//hp�̓[���ȉ��ɂ͂Ȃ�Ȃ�

	}
}