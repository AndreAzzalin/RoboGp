package robogp.cards;

import robogp.logic.Logic;

public class BackupCard extends Card {

    public BackupCard(int priority, Logic logic) {
        super(priority, logic);
        super.setMove(-1);
        super.setName("card-backup");
        super.setImage();
    }
}
