//�}���I�Ɛ키�ہA�����̃`�[���Ƃ��đI���ł���
//�L�����N�^�[�����̊�b�ƂȂ�e�N���X���쐬����B
//�Ȃ��A���K�̂��߁A�����Đe�N���X��
//�C���^�[�t�F�[�X�Ƃ��Ē�`���邱�Ƃɒ��킷��B
//�C���^�[�t�F�[�X�͊ȒP�Ɍ����Γ��ɒ��ۓx�̍������ۃN���X

public interface Character
{
	public abstract int selectAttack();

	public abstract void callAttack(int i, Mario mar, Character c1, Character c2);

	public abstract void attack1(Mario mar);

	public abstract void attack2(Mario mar);

	public abstract void specialAttack(Mario mar);

	public abstract int getHp();

	public abstract void setHp(int h);

	public abstract String getNamae();
}

//�ȏ�̂悤�ɂ��̃C���^�[�t�F�[�X���p������
//�q�N���X�́A�K��2��ނ̒ʏ�U���ƁA
//1�̕K�E�U�����Œ�������ƂɂȂ�B