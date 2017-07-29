package robogp.cards;

import robogp.logic.Logic;
import robogp.robodrome.Rotation;

public class TurnRightCard extends TurnCard {

    public TurnRightCard(int priority, Logic logic) {
        super(priority, logic);
        super.setRot(Rotation.CW90);
        super.setName("card-turnR");
        super.setImage();
    }
}
