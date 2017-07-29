package Test;

import java.util.ArrayList;
import java.util.Random;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import robogp.logic.Logic;
import robogp.matchmanager.RobotMatch;
import robogp.matchmanager.RobotMarker;
import robogp.robodrome.Direction;
import robogp.robodrome.view.RobodromeView;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import robogp.matchmanager.RobotMarker;
import robogp.robodrome.Direction;
import robogp.robodrome.Robodrome;
import robogp.robodrome.view.RobodromeView;

/**
 *
 * @author Andrea
 */
public class TestLogic {

    public static Logic logic;

    private enum Robodrome {
        riskyexchange, checkmate
    };

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Execution of JUNIT test file started");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Execution of JUNIT test file done");

    }

    @Before
    public void setUp() {
        //random dimension
        int CELL_DIMENSION = 20 + (new Random()).nextInt(100 - 20 + 1);
        /*
        * random robodrome
        * String random = ((new Random().nextInt() < 0) ? Robodrome.riskyexchange : Robodrome.checkmate).name();
         */
        RobodromeView robodromeView = new RobodromeView(new robogp.robodrome.Robodrome("robodromes/riskyexchange.txt"), CELL_DIMENSION);
        logic = new Logic(robodromeView);

        RobotMatch r1 = new RobotMatch(new RobotMarker("a", "red"), 5, 0);
        r1.setDir(Direction.E);

        RobotMatch r2 = new RobotMatch(new RobotMarker("b", "violet"), 5, 1);
        r2.setDir(Direction.N);

        RobotMatch r3 = new RobotMatch(new RobotMarker("b", "violet"), 1, 2);
        r3.setDir(Direction.N);

        logic.setRobots(new ArrayList<RobotMatch>());
        logic.getRobots().add(r1);
        logic.getRobots().add(r2);
        logic.getRobots().add(r3);

        //logic.fireLaser();
    }

    @Test
    public void testGetObstacleLaser() {
        RobotMatch r1 = logic.getRobots().get(0);
        boolean obstacleFound = (logic.getObstacleLaser(r1).getValue() != null);

        r1.setX(0);
        r1.setY(0);
        r1.setDir(Direction.W);
        boolean obstacleNotFound = (logic.getObstacleLaser(r1).getValue() == null);

        assertTrue(obstacleFound);

    }

    @Test
    public void testMoveAction() {
        RobotMatch r3 = logic.getRobots().get(2);
        int xBefore = r3.getX();
        int yBefore = r3.getY();

        //non si muove se sbatte contro i muri
        logic.moveAction(xBefore, yBefore, r3.getDir(), r3, 3);
        boolean dontMoveAgainstWall = (r3.getX() == xBefore && r3.getY() == yBefore);

        //si muove se non sbatte contro i muri
        r3.setDir(Direction.E);
        logic.moveAction(xBefore, yBefore, r3.getDir(), r3, 2);
        boolean moveWithoutWall = (r3.getX() == xBefore && r3.getY() == (yBefore + 2));

        //si muove se si ferma su una belt
        r3.setDir(Direction.W);
        logic.moveAction(r3.getX(), r3.getY(), r3.getDir(), r3, 3);
        boolean moveWithBelt = (r3.getX() == (xBefore + 1) && r3.getY() == (yBefore - 1));

        r3.setDir(Direction.E);
        r3.setX(0);
        r3.setY(0);
        logic.moveAction(r3.getX(), r3.getY(), Direction.E, r3, 1);
        boolean changeDirWithBelt = (r3.getDir() != Direction.E);

        //puÃ² uscire dal robodromo 
        boolean goOutOfBounds = false;
        r3.setX(0);
        r3.setY(0);
        r3.setDir(Direction.W);
        logic.moveAction(r3.getX(), r3.getY(), r3.getDir(), r3, 2);
        if (r3.getX() < 0 || r3.getY() < 0) {
            goOutOfBounds = true;
        }

        //smette di muoversi se cade in una buca
        r3.setX(0);
        r3.setY(4);
        yBefore = 4;
        r3.setDir(Direction.E);
        logic.moveAction(r3.getX(), r3.getY(), r3.getDir(), r3, 1);
        boolean stayOnPit = (r3.getY() == 4);

        assertTrue(dontMoveAgainstWall && moveWithoutWall && moveWithBelt && goOutOfBounds && changeDirWithBelt && stayOnPit);
    }

}
