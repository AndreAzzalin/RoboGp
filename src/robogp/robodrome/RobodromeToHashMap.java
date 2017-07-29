package robogp.robodrome;

import java.util.HashMap;
import javafx.util.Pair;

public class RobodromeToHashMap {
    
    //assegna lke posizioni  dei dock iniziali 

    private HashMap<String, Pair<Integer, Integer>> initialPositions;

    public RobodromeToHashMap(String robodrome) {
        initialPositions = new HashMap<>();
        switch (robodrome) {
            case "checkmate":
                initialPositions.put("1", new Pair<>(5, 1));
                initialPositions.put("2", new Pair<>(6, 1));
                initialPositions.put("3", new Pair<>(3, 1));
                initialPositions.put("4", new Pair<>(8, 1));
                initialPositions.put("5", new Pair<>(1, 1));
                initialPositions.put("6", new Pair<>(10, 1));
                initialPositions.put("7", new Pair<>(0, 1));
                initialPositions.put("8", new Pair<>(11, 1));
                break;
            case "riskyexchange":
                initialPositions.put("1", new Pair<>(5, 0));
                initialPositions.put("2", new Pair<>(6, 0));
                initialPositions.put("3", new Pair<>(3, 1));
                initialPositions.put("4", new Pair<>(8, 1));
                initialPositions.put("5", new Pair<>(1, 2));
                initialPositions.put("6", new Pair<>(10, 2));
                initialPositions.put("7", new Pair<>(0, 3));
                initialPositions.put("8", new Pair<>(11, 3));
                break;
        }
    }

    public HashMap<String, Pair<Integer, Integer>> getInitialPositions() {
        return initialPositions;
    }
}
