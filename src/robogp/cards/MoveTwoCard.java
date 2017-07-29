package robogp.cards;

import robogp.logic.Logic;

public class MoveTwoCard extends Card {

    public MoveTwoCard(int priority, Logic logic) {
        super(priority, logic);
        super.setMove(2);
        super.setName("card-move2");
        super.setImage();
    }

}
