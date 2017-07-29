package robogp.cards;

import robogp.logic.Logic;
import robogp.robodrome.Rotation;

public class TurnLeftCard extends TurnCard {

    public TurnLeftCard(int priority, Logic logic) {
        super(priority, logic);
        super.setRot(Rotation.CCW90);
        super.setName("card-turnL");
        super.setImage();
    }

}
