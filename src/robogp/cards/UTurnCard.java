package robogp.cards;

import robogp.logic.Logic;
import robogp.robodrome.Rotation;

public class UTurnCard extends TurnCard {

    public UTurnCard(int priority, Logic logic) {
        super(priority, logic);
        super.setRot(Rotation.CCW180);
        super.setName("card-uturn");
        super.setImage();
    }
}
