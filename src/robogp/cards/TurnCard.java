package robogp.cards;

import robogp.logic.Logic;
import robogp.matchmanager.RobotMatch;

import robogp.robodrome.Direction;
import robogp.robodrome.Rotation;

public class TurnCard extends Card {

    private Rotation rot;
    private Direction d;

    public TurnCard(int priority, Logic logic) {
        super(priority, logic);
    }
 
    public void setRot(Rotation rot) {
        this.rot = rot;
    }

    public void setDirection(Direction d) {
        this.d = d;
    }

    @Override
    public void execute(RobotMatch rm) {
        rm.setDir(Rotation.changeDirection(rm.getDir(), rot));
        logic.getRv().addRobotMove(rm.getRobotMarker(), move, rm.getDir(), rot);
    }
}

