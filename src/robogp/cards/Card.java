package robogp.cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import robogp.logic.Logic;
import robogp.matchmanager.RobotMatch;

public abstract class Card implements Serializable {

    private transient BufferedImage image;
    private String name;
    private final int priority;
    transient Logic logic;
    int move;

    Card(int priority, Logic logic) {
        this.priority = priority;
        this.logic = logic;
    }

    public int getPriority() {
        return priority;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Logic getLogic() {
        return logic;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public void setImage() {
        try {
            image = ImageIO.read(new File("test/mockups/icons/" + name + ".png"));
        } catch (IOException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void execute(RobotMatch r) {
        logic.moveAction(r.getX(), r.getY(), r.getDir(), r, this.move);
    }

    @Override
    public String toString() {
        return "Card{" + " name=" + name + ", priority=" + priority + '}';
    }

}
