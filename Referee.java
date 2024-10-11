public class Referee {

    private Mario mario;
    private Character character1;
    private Character character2;

    Referee(Mario mario, Character character1, Character character2) {
        this.mario = mario;
        this.character1 = character1;
        this.character2 = character2;
    }

    public boolean isGameInProgress() {

        if (character1.isDead() && character2.isDead()) {
            return false;
        }
        
        if (mario.isDead()) {
            return false;
        }

        return true;
    }

    public void announceStatus() {

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("マリオHP：" + mario.getHp() + "\n");
		System.out.print(character1.getNamae() + "HP：" + character1.getHp() + "  ");
		System.out.println(character2.getNamae() + "HP：" + character2.getHp());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");	
    }

    public void announceVictory() {

        if (mario.isSurviving()) {
            System.out.println("マリオの勝ち！");

            // 両サイドとも生きている状況でこの関数が呼ばれる想定はないが、念のためにリターンしておく
            return;
		} 

        if (character1.isSurviving() || character2.isSurviving()) {
            System.out.println(character1.getNamae() + "&" + character2.getNamae() + "のチームの勝ち！");
		}
    }
}