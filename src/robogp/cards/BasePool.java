package robogp.cards;

import java.util.ArrayList;
import java.util.Collections;

import robogp.logic.Logic;

public class BasePool {

    private ArrayList<Card> deck;
    private Logic logic;

    public BasePool(Logic logic) {
        this.logic = logic;
        reset();
    }

    public void reset() {
        deck = new ArrayList<>();
        UTurnCard u = new UTurnCard(0, this.logic);
        TurnLeftCard tl = new TurnLeftCard(0, this.logic);
        TurnRightCard tr = new TurnRightCard(0, this.logic);
        BackupCard b = new BackupCard(0, this.logic);
        MoveOneCard m1 = new MoveOneCard(0, this.logic);
        MoveTwoCard m2 = new MoveTwoCard(0, this.logic);
        MoveThreeCard m3 = new MoveThreeCard(0, this.logic);

        deck.add(u);
        deck.add(tl);
        deck.add(tr);
        deck.add(b);
        deck.add(m1);
        deck.add(m2);
        deck.add(m3);
    }

    /**
     * Shuffles the deck. Use this before getting cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
