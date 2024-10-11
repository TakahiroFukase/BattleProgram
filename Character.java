//マリオと戦う際、自分のチームとして選択できる
//キャラクターたちの基礎となる親クラスを作成する。
//なお、練習のため、あえて親クラスは
//インターフェースとして定義することに挑戦する。
//インターフェースは簡単に言えば特に抽象度の高い抽象クラス

public interface Character {
	public abstract void selectAttack();

	public abstract void callAttack(Mario mar, Character c1, Character c2);

	public abstract void attack1(Mario mar);

	public abstract void attack2(Mario mar);

	public abstract void specialAttack(Mario mar);

	public abstract int getHp();

	public abstract void setHp(int h);

	public abstract String getNamae();

	public abstract boolean isSurviving();

	public abstract boolean isDead();
}

//以上のようにこのインターフェースを継承した
//子クラスは、必ず2種類の通常攻撃と、
//1つの必殺攻撃を最低限持つことになる。