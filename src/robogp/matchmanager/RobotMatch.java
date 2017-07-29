package robogp.matchmanager;

import java.io.Serializable;
import robogp.cards.PersonalPool;
import robogp.matchmanager.RobotMarker;
import robogp.robodrome.Direction;

public class RobotMatch implements Serializable {

    private RobotMarker robotMarker;
    private int numVite;
    private int hp;

    private int x;
    private int y;
    private Direction dir;
    private boolean fallen;
    private PersonalPool pl;
     boolean dead = false;

    public RobotMatch(RobotMarker rm, int x, int y) {
        robotMarker = rm;
        hp = 10;
        numVite = 3;
        this.x = x;
        this.y = y;
        pl = new PersonalPool();
     
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void decrementHp() {
        this.hp--;
    }

    public int getHp() {
        return hp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public boolean isFallen() {
        return fallen;
    }

    public void setFallen(boolean fallen) {
        this.fallen = fallen;
    }

    public void setDied(boolean t) {
       dead = t;
    }

    public void unaryDecrementNumLives() {
        numVite--;
    }

    public PersonalPool getPl() {
        return pl;
    }

    public int getNumVite() {
        return numVite;
    }

    public boolean isDied() {
        return dead;
    }

    public void unaryDecrementHp() {
        hp--;

    }

    public RobotMarker getRobotMarker() {
        return robotMarker;
    }

    public String[] getIstruzioniToString() {
        String[] nomiIstr = null;
        for (int i = 0; i < pl.getIstruzioni().size(); i++) {
            nomiIstr[i] = pl.getIstruzioni().get(i).getName();
        }
        return nomiIstr;
    }

    @Override
    public String toString() {
        return "RobotMatch{" + "robotMarker=" + robotMarker + ", x=" + x + ", y=" + y + ", dir=" + dir + '}';
    }
}
