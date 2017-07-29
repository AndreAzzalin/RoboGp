package robogp.cards;

import robogp.logic.Logic;

public class MoveOneCard extends Card {

    public MoveOneCard(int priority, Logic logic) {
        
        super(priority, logic);
        super.setMove(1); 
        super.setName("card-move1");
        super.setImage();
    }
}
