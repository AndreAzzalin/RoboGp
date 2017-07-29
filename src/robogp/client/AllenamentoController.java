package robogp.client;

import robogp.client.gui.GuiAllenamento;
import java.util.ArrayList;
import java.util.Observable;
import javafx.util.Pair;
import javax.swing.JOptionPane;
import robogp.cards.BackupCard;
import robogp.cards.Card;
import robogp.cards.MoveOneCard;
import robogp.cards.MoveThreeCard;
import robogp.cards.MoveTwoCard;
import robogp.cards.TurnLeftCard;
import robogp.cards.TurnRightCard;
import robogp.cards.UTurnCard;
import robogp.logic.Logic;
import robogp.matchmanager.RobotMatch;
import robogp.matchmanager.RobotMarker;
import robogp.robodrome.BoardCell;
import robogp.robodrome.Direction;
import robogp.robodrome.Robodrome;
import robogp.robodrome.view.RobodromeAnimationObserver;
import robogp.robodrome.view.RobodromeView;

/**
 *
 * @author paranoia
 */
public class AllenamentoController implements RobodromeAnimationObserver {

    private RobodromeView rv;
    private RobotMatch robot;
    private Logic logic;
    public static AllenamentoController singleInstance;
    private Card move1, move2, move3, backup, uTurn, turnL, turnR;
    private Add a;
    private ArrayList<RobotMatch> robotMatchList = new ArrayList<>();
    private GuiAllenamento gui;

    public AllenamentoController() {
    }

    public static AllenamentoController getInstance() {
        if (AllenamentoController.singleInstance == null) {
            AllenamentoController.singleInstance = new AllenamentoController();
        }
        return AllenamentoController.singleInstance;
    }

    public Card getMove1() {
        return move1;
    }

    public Logic getLogic() {
        return logic;
    }

    public Card getMove2() {
        return move2;
    }

    public Card getMove3() {
        return move3;
    }

    public Card getBackup() {
        return backup;
    }

    public Card getuTurn() {
        return uTurn;
    }

    public Card getTurnL() {
        return turnL;
    }

    public Card getTurnR() {
        return turnR;
    }

    public void creaRobodromo(String rbdName) {
        rv = new RobodromeView(new Robodrome("robodromes/" + rbdName + ".txt"), 35);
        logic = new Logic(rv);
        rv.addObserver(this);
    }

    public void piazzaRobot(String robotName, String direzione, int x, int y) {
        robot = new RobotMatch(new RobotMarker("robot-" + robotName, robotName), x, y);

        Direction d = Direction.E;

        switch (direzione) {
            case "N":
                d = Direction.N;
                robot.setDir(Direction.N);
                break;
            case "S":
                d = Direction.S;
                robot.setDir(Direction.S);
                break;
            case "E":
                d = Direction.E;
                robot.setDir(Direction.E);
                break;
            case "W":
                d = Direction.W;
                robot.setDir(Direction.W);
                break;
        }

        getRv().placeRobot(robot.getRobotMarker(), d, robot.getX(), robot.getY(), true);

        //aggiungo l'observer per il BasePool(pool per allenamento)
        a = new Add();
        a.addObserver(robot.getPl());

        //aggiungo il robot(l'unico) nella lista di robots di logic
        robotMatchList = new ArrayList<>();
        robotMatchList.add(robot);
        logic.setRobots(robotMatchList);

    }

    //creo carta Move1 e la inserisco nl PoolPersonale
    public void addMove1Card() {
        move1 = new MoveOneCard(0, getLogic());
        a.addCard(move1);

    }

    public void addMove2Card() {
        move2 = new MoveTwoCard(0, getLogic());
        a.addCard(move2);

    }

    public void addMove3Card() {
        move3 = new MoveThreeCard(0, getLogic());
        a.addCard(move3);
    }

    public void addBackUpCard() {
        backup = new BackupCard(0, getLogic());
        a.addCard(backup);

    }

    public void addTurnLCard() {
        turnL = new TurnLeftCard(0, getLogic());
        a.addCard(turnL);

    }

    public void addTurnRCard() {
        turnR = new TurnRightCard(0, getLogic());
        a.addCard(turnR);

    }

    public void addUTurnCard() {
        uTurn = new UTurnCard(0, getLogic());
        a.addCard(uTurn);

    }

    public RobodromeView getRv() {
        return rv;
    }

    public RobotMatch getRobot() {
        return robot;
    }

    public boolean isDeadRobot() {
        //sollevo l'eccezione per provare cheil robot è uscito dal rovodromo
        try {
            BoardCell[][] c = rv.getDrome().getBoard();
            if (c[robot.getX()][robot.getY()].hasWall(Direction.W)) {
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            robot.setHp(0);
        }
        return robot.getHp() <= 0;
    }

    //Carico le carte nei registri e li aggiungo alla coda di animazioni da eseguire
    private void loadRegistri() {
        for (Card card : robot.getPl().getIstruzioni()) {
            card.execute(robot);
        }

    }

    //Avvia animazioni delle carte
    public void runProgramma() {
        loadRegistri();
        rv.play();
    }

    public void riProgramma() {
        robot.getPl().getIstruzioni().clear();

    }

    public boolean personalPoolEmpty() {
        return getRobot().getPl().getIstruzioni().isEmpty();
    }

    //classe observable per notificare l'add delle carte nel PersolPool
    class Add extends Observable {

        private void addCard(Card c) {
            setChanged();
            notifyObservers(new Pair<>(true, c));
        }

        private void removeCard(Card c) {
            setChanged();
            notifyObservers(new Pair<>(false, c));
        }
    }

    @Override
    public void animationStarted() {

    }

    @Override
    public void animationFinished() {
        if (isDeadRobot()) {
            JOptionPane.showMessageDialog(gui, "Robot morto, ripiazzalo per continuare l'allenamento");
        }

    }

}
