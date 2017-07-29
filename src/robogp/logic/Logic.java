package robogp.logic;

import robogp.matchmanager.RobotMatch;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;
import robogp.robodrome.BeltCell;
import robogp.robodrome.BoardCell;
import robogp.robodrome.Direction;
import robogp.robodrome.FloorCell;
import robogp.robodrome.Rotation;
import robogp.robodrome.view.RobodromeView;

public class Logic {

    private final RobodromeView rv;
    private ArrayList<RobotMatch> robots;

    public Logic(RobodromeView rv) {
        this.rv = rv;
    }

    public RobodromeView getRv() {
        return rv;
    }

    public void setRobots(ArrayList<RobotMatch> robots) {
        this.robots = robots;
    }

    public ArrayList<RobotMatch> getRobots() {
        return robots;
    }

    public boolean canMoveSingleRobotMarker(int x, int y, Direction dir) {
        BoardCell[][] cell = rv.getDrome().getBoard();
        
        try {
            switch (dir) {
                case N:
                    return (!cell[x][y].hasWall(dir) && !cell[x - 1][y].hasWall(Direction.S));
                case S:
                    return (!cell[x][y].hasWall(dir) && !cell[x + 1][y].hasWall(Direction.N));
                case E:
                    return (!cell[x][y].hasWall(dir) && !cell[x][y + 1].hasWall(Direction.W));
                case W:
                    return (!cell[x][y].hasWall(dir) && !cell[x][y - 1].hasWall(Direction.E));
            }

        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            return true;
        }
        return false;
    }

    private boolean onPit(int x, int y) {
        try {
            char c = checkType(x, y);
            return c == 'P';
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean onBelt(int x, int y) {
        char c = checkType(x, y);
        return c == 'B';
    }

    private boolean onExpressBelt(int x, int y) {
        char c = checkType(x, y);
        return c == 'E';
    }

    private boolean onUpgrade(int x, int y) {
        BoardCell[][] cell = rv.getDrome().getBoard();
        if (cell[x][y] instanceof FloorCell) {
            return ((FloorCell) cell[x][y]).isUpgrade();
        } else {
            return false;
        }
    }

    private boolean isOnRotatorL(RobotMatch r) {
        int x= r.getX();
        int y = r.getY();
                
        BoardCell[][] cell = rv.getDrome().getBoard();
        try{
             if (cell[x][y] instanceof FloorCell) {
            return ((FloorCell) cell[x][y]).isLeftRotator();
        } else {
            return false;
        }
        }catch(ArrayIndexOutOfBoundsException exception){
            return false;
        }
       
    }

    private boolean isOnRotatorR(RobotMatch r) {
          int x= r.getX();
        int y = r.getY();
        BoardCell[][] cell = rv.getDrome().getBoard();
        try{
             if (cell[x][y] instanceof FloorCell) {
            return ((FloorCell) cell[x][y]).isRightRotator();
        } else {
            return false;
        }
            
        }catch(ArrayIndexOutOfBoundsException exception){
            return false;
        }
       
    }

    private boolean hitbyLaser(int x, int y) {
        BoardCell[][] cell = rv.getDrome().getBoard();
        return (cell[x][y].hasHorizontalLaser() || cell[x][y].hasVerticalLaser());
    }

    private boolean notOutOfBounds(int x, int y) {
        BoardCell[][] cell = rv.getDrome().getBoard();
        try {
            cell[x][y].getType();
            return true;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private char checkType(int x, int y) {
        BoardCell[][] cell = rv.getDrome().getBoard();
        try {
            return cell[x][y].getType();
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            return '!';
        }
    }

    public void moveAction(int x, int y, Direction dir, RobotMatch r, int move) {
        RobotMatch robotPushed = null;

        if (move < 0) {
            move = -move;

            dir = Rotation.changeDirection(dir, Rotation.CCW180);
        }

        for (int i = 0; i < move; i++) {
            if ((canMoveRobotsMarkerStack(r, dir))) {
                if (!r.isDied()) {
                    robotPushed = robotToBePush(r, dir);
                    rv.addRobotMove(r.getRobotMarker(), 1, dir, Rotation.NO);

                    switch (dir) {
                        case N:
                            r.setX(--x);
                            break;
                        case S:
                            r.setX(++x);
                            break;
                        case E:
                            r.setY(++y);
                            break;
                        case W:
                            r.setY(--y);
                            break;
                    }
                }

                if (isOutOfRobodrome(r) || isOnPit(r)) {
                    if (!r.isDied()) {
                        r.setHp(0);
                        r.unaryDecrementNumLives();
                        r.setDied(true);
                    }

                }

                if (isOnPit(r)) {
                    rv.addRobotFall(r.getRobotMarker());
                }

                if (robotPushed != null) {
                    this.moveAction(robotPushed.getX(), robotPushed.getY(), dir, robotPushed, 1);
                }
            }
        }

        if (isOnBelt(r)) {
            beltAction(r.getX(), r.getY(), r.getDir(), r);
        }
        
                 if(isOnRotatorR(r)){
            Direction  rot = Rotation.changeDirection(r.getDir(), Rotation.CW90);
                        r.setDir(rot);
           rv.addRobotMove(r.getRobotMarker(),0,rot,Rotation.CW90);
                
        } else if(isOnRotatorL(r)){
               Direction  rot = Rotation.changeDirection(r.getDir(), Rotation.CCW90);
               r.setDir(rot);
            rv.addRobotMove(r.getRobotMarker(),0,rot,Rotation.CCW90);
        }
            
        
   

    }

    private void beltAction(int x, int y, Direction dir, RobotMatch rm) {
        RobotMatch robotPushed = null;
        int steps = onBelt(x, y) ? 1 : 2;
        BeltCell cell = (BeltCell) rv.getDrome().getCell(x, y);
        Direction direction = cell.getOutputDirection();
        Rotation rot = Rotation.getCounterClockwiseRotation(dir, direction);

        for (int i = 0; i < steps; i++) {
            if (canMoveRobotsMarkerStack(rm, direction)) {
                robotPushed = robotToBePush(rm, direction);
                rv.addRobotMove(rm.getRobotMarker(), 1, direction, rot);

                switch (direction) {
                    case N:
                        rm.setX(--x);
                        break;
                    case S:
                        rm.setX(++x);
                        break;
                    case E:
                        rm.setY(++y);
                        break;
                    case W:
                        rm.setY(--y);
                        break;
                }
            } else {
                rv.addRobotMove(rm.getRobotMarker(), 0, direction, rot);
            }

            rm.setDir(direction);
            rot = Rotation.NO;

            if (robotPushed != null) {
                this.moveAction(robotPushed.getX(), robotPushed.getY(), direction, robotPushed, 1);
            }
        }

        if (isOnBelt(rm)) {
            cell = (BeltCell) rv.getDrome().getCell(rm.getX(), rm.getY());
            direction = cell.getOutputDirection();

            if (direction != rm.getDir()) {

                switch (direction) {
                    case N:
                        switch (rm.getDir()) {
                            case S:
                                rot = Rotation.CW180;
                                break;
                            case E:
                                rot = Rotation.CCW90;
                                break;
                            case W:
                                rot = Rotation.CW90;
                                break;
                        }
                        break;

                    case S:
                        switch (rm.getDir()) {
                            case N:
                                rot = Rotation.CW180;
                                break;
                            case E:
                                rot = Rotation.CW90;
                                break;
                            case W:
                                rot = Rotation.CCW90;
                                break;
                        }
                        break;

                    case E:
                        switch (rm.getDir()) {
                            case S:
                                rot = Rotation.CCW90;
                                break;
                            case N:
                                rot = Rotation.CW90;
                                break;
                            case W:
                                rot = Rotation.CW180;
                                break;
                        }
                        break;

                    case W:
                        switch (rm.getDir()) {
                            case S:
                                rot = Rotation.CW90;
                                break;
                            case N:
                                rot = Rotation.CCW90;
                                break;
                            case E:
                                rot = Rotation.CW180;
                                break;
                        }
                        break;
                }

                rv.addRobotMove(rm.getRobotMarker(), 0, direction, rot);
                rm.setDir(direction);
            }
        }
    }

    private boolean isOnBelt(RobotMatch rm) {
        return (onBelt(rm.getX(), rm.getY()) || onExpressBelt(rm.getX(), rm.getY()));
    }

    private boolean isOnPit(RobotMatch rm) {
        return (onPit(rm.getX(), rm.getY()));
    }

    //restituisce l'eventuale robot da spingere
    private RobotMatch robotToBePush(RobotMatch rm, Direction dir) {
        for (RobotMatch otherRobot : robots) {
            if (!otherRobot.getRobotMarker().getName().equals(rm.getRobotMarker().getName())) {
                switch (dir) {
                    case N:
                        if (otherRobot.getX() == rm.getX() - 1 && otherRobot.getY() == rm.getY()) {
                            return otherRobot;
                        }
                        break;
                    case S:
                        if (otherRobot.getX() == rm.getX() + 1 && otherRobot.getY() == rm.getY()) {
                            return otherRobot;
                        }
                        break;
                    case E:
                        if (otherRobot.getX() == rm.getX() && otherRobot.getY() == rm.getY() + 1) {
                            return otherRobot;
                        }
                        break;
                    case W:
                        if (otherRobot.getX() == rm.getX() && otherRobot.getY() == rm.getY() - 1) {
                            return otherRobot;
                        }
                        break;
                }
            }
        }

        return null;
    }

    //spara il laser
    public void fireLaser() {
        for (RobotMatch robot : robots) {
            if (!robot.isDied()) {
                Pair<Pair<Integer, Integer>, Pair<String, RobotMatch>> p = getObstacleLaser(robot);
                RobotMatch hittedRobot = p.getValue().getValue();

                if (hittedRobot != null) {
                    hittedRobot.unaryDecrementHp();

                    if (hittedRobot.getHp() <= 0) {
                        hittedRobot.setDied(true);
                        hittedRobot.unaryDecrementNumLives();
                    }
                }

                switch (robot.getDir()) {
                    case N:
                        rv.addLaserFire(robot.getRobotMarker(),
                                robot.getDir(), robot.getX(), p.getKey().getKey(),
                                (p.getValue().getKey().equals("R")), (p.getValue().getKey().equals("W")));

                        if (hittedRobot != null) {
                            rv.addRobotHit(hittedRobot.getRobotMarker(), Direction.S);
                        }
                        break;
                    case S:
                        rv.addLaserFire(robot.getRobotMarker(),
                                robot.getDir(), robot.getX(), p.getKey().getKey(),
                                (p.getValue().getKey().equals("R")), (p.getValue().getKey().equals("W")));

                        if (hittedRobot != null) {
                            rv.addRobotHit(hittedRobot.getRobotMarker(), Direction.N);
                        }
                        break;
                    case E:
                        rv.addLaserFire(robot.getRobotMarker(),
                                robot.getDir(), robot.getY(), p.getKey().getValue(),
                                (p.getValue().getKey().equals("R")), (p.getValue().getKey().equals("W")));

                        if (hittedRobot != null) {
                            rv.addRobotHit(hittedRobot.getRobotMarker(), Direction.W);
                        }
                        break;
                    case W:
                        rv.addLaserFire(robot.getRobotMarker(),
                                robot.getDir(), robot.getY(), p.getKey().getValue(),
                                (p.getValue().getKey().equals("R")), (p.getValue().getKey().equals("W")));

                        if (hittedRobot != null) {
                            rv.addRobotHit(hittedRobot.getRobotMarker(), Direction.E);
                        }
                        break;
                }
            }
        }

        rv.addHideLaser();
    }

    //ritorna le coordinate dell'ostacolo del raggio di laser e l'ostacolo stesso
    public Pair<Pair<Integer, Integer>, Pair<String, RobotMatch>> getObstacleLaser(RobotMatch rm) {
        BoardCell[][] cell = rv.getDrome().getBoard();
        String obstacle = "N";
        RobotMatch robotObstacle = null;
        int x = rm.getX();
        int y = rm.getY();
        
        
        switch (rm.getDir()) {
            case N:
                while (x>0 &&x < rv.getDrome().getRowCount() && !cell[x][y].hasWall(Direction.N)
                        && !cell[x - 1][y].hasWall(Direction.S)
                        && !robotMarkerIn(x - 1, y)) {
                    --x;
                }

                if (x > 0) {
                    if (cell[x][y].hasWall(Direction.N) || cell[x - 1][y].hasWall(Direction.S)) {
                        obstacle = "W";
                    } else {
                        --x;
                        obstacle = "R";
                        robotObstacle = getRobotMarkerIn(x, y);
                    }
                } else {
                    if (x > 0 && cell[x][y].hasWall(Direction.N)) {
                        obstacle = "W";
                    }
                }

                break;
            case S:
                while (x < rv.getDrome().getRowCount() - 1
                        && !cell[x][y].hasWall(Direction.S)
                        && !cell[x + 1][y].hasWall(Direction.N)
                        && !robotMarkerIn(x + 1, y)) {
                    ++x;
                }

                if (x < rv.getDrome().getRowCount() - 1) {
                    if (cell[x][y].hasWall(Direction.S) || cell[x + 1][y].hasWall(Direction.N)) {
                        obstacle = "W";
                    } else {
                        ++x;
                        obstacle = "R";
                        robotObstacle = getRobotMarkerIn(x, y);
                    }
                } else {
                    if (x < rv.getDrome().getRowCount() && cell[x][y].hasWall(Direction.S)) {
                        obstacle = "W";
                    }
                }

                break;
            case E:
                while (y < rv.getDrome().getColumnCount() - 1
                        && !cell[x][y].hasWall(Direction.E)
                        && !cell[x][y + 1].hasWall(Direction.W)
                        && !robotMarkerIn(x, y + 1)&& !isOutOfRobodrome(rm)) {
                    ++y;
                }

                if (y < rv.getDrome().getColumnCount() - 1) {
                    if (cell[x][y].hasWall(Direction.E) || cell[x][y + 1].hasWall(Direction.W)) {
                        obstacle = "W";
                    } else {
                        ++y;
                        obstacle = "R";
                        robotObstacle = getRobotMarkerIn(x, y);
                    }
                } else {
                    if (y < rv.getDrome().getColumnCount() && cell[x][y].hasWall(Direction.E)) {
                        obstacle = "W";
                    }
                }
                break;
            case W:
                while (y >0 && !cell[x][y].hasWall(Direction.W)
                        && !cell[x][y - 1].hasWall(Direction.E)
                        && !robotMarkerIn(x, y - 1)&& !isOutOfRobodrome(rm)) {
                    --y;
                }

                if (y > 0) {
                    if (cell[x][y].hasWall(Direction.W) || cell[x][y - 1].hasWall(Direction.E)) {
                        obstacle = "W";
                    } else {
                        --y;
                        obstacle = "R";
                        robotObstacle = getRobotMarkerIn(x, y);
                    }
                } else {
                    if (y > 0 && cell[x][y].hasWall(Direction.W)) {

                        obstacle = "W";
                    }
                }
                break;
        }

        return new Pair<>(new Pair<>(x, y), new Pair<>(obstacle, robotObstacle));
    }

    //testa se c'è un robot in x e y
    private boolean robotMarkerIn(int x, int y) {
        return robots.stream().anyMatch((robot) -> (robot.getX() == x && robot.getY() == y));
    }

    //testa se è possibile muovere una pila di robot lungo una direzione (pila di dimensione 1 anche)
    private boolean canMoveRobotsMarkerStack(RobotMatch rm, Direction dir) {
        RobotMatch robotToBePush = robotToBePush(rm, dir);

        if (robotToBePush == null) {
            switch (dir) {
                case N:
                  return this.canMoveSingleRobotMarker(rm.getX(), rm.getY(), Direction.N);
                case S:
                    return this.canMoveSingleRobotMarker(rm.getX(), rm.getY(), Direction.S);
                case E:
                    return this.canMoveSingleRobotMarker(rm.getX(), rm.getY(), Direction.E);
                case W:
                    return this.canMoveSingleRobotMarker(rm.getX(), rm.getY(), Direction.W);
            }
        }

        return this.canMoveRobotsMarkerStack(robotToBePush, dir);
    }

    private RobotMatch getRobotMarkerIn(int x, int y) {
        for (RobotMatch robot : robots) {
            if (robot.getX() == x && robot.getY() == y) {
                return robot;
            }
        }

        return null;
    }

    private boolean isOutOfRobodrome(RobotMatch robot) {
        return (robot.getX() < 0 || robot.getY() < 0);
    }

    //bug nel codice Picardi, quando si ripiazza il robot non si visualizza l'immagine
    public void replaceDiedRobotMarkers(HashMap<String, Pair<Integer, Integer>> initialPositions) {
        for (RobotMatch robot : robots) {
            if (robot.isDied() && robot.getNumVite() > 0) {

                int x = initialPositions.get(
                        Integer.toString(robot.getRobotMarker().getDock())).getKey();
                int y = initialPositions.get(
                        Integer.toString(robot.getRobotMarker().getDock())).getValue();

                robot.setHp(10);
                robot.setDir(Direction.E);
                robot.setX(x);
                robot.setY(y);
                robot.setDied(false);
                robot.getPl().getIstruzioni().clear();

                rv.changeRobotPosition(robot.getRobotMarker(), Direction.E, x, y, true);
            }
        }
    }
}
