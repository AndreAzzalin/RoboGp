package robogp.cards;

import robogp.logic.Logic;

public class MoveThreeCard extends Card {

    public MoveThreeCard(int priority, Logic logic) {

        super(priority, logic);
        super.setMove(3);
        super.setName("card-move3");
        super.setImage();
    }

}
