package robogp.cards;

import java.util.ArrayList;
import java.util.Collections;
import robogp.logic.Logic;

public class GlobalPool {

   
    private ArrayList<Card> deck;
    private Logic logic;

    public GlobalPool(Logic logic) {
        this.logic = logic;
        reset();
    }

    /*
    Commands
     */
    /**
     * Resets the deck and recreates all the cards in order. "Unshuffles them".
     * Use this after the getCards() method to get a full deck again.
     */
    public void reset() {

        deck = new ArrayList<>();

        // U_TURN Cards
        int point = 10;
        for (int i = 1; i <= 6; i++) {
            UTurnCard u = new UTurnCard(point, this.logic);
            deck.add(u);
            point = point + 10;
        }

        // TURN LEFT Cards
        point = 70;
        for (int i = 1; i <= 18; i++) {
            TurnLeftCard t = new TurnLeftCard(point, this.logic);
            deck.add(t);
            point = point + 20;
        }

        // TURN RIGHT Cards
        point = 80;
        for (int i = 1; i <= 18; i++) {
            TurnRightCard t = new TurnRightCard(point, this.logic);
            deck.add(t);
            point = point + 20;
        }

        // BACKUP Cards
        point = 430;
        for (int i = 1; i <= 6; i++) {
            BackupCard b = new BackupCard(point, this.logic);
            deck.add(b);
            point = point + 10;
        }

        // MOVE_ONE Cards
        point = 490;
        for (int i = 1; i <= 18; i++) {
            MoveOneCard m = new MoveOneCard(point, this.logic);
            deck.add(m);
            point = point + 10;
        }

        // MOVE_TWO Cards
        point = 670;
        for (int i = 1; i <= 12; i++) {
            MoveTwoCard m = new MoveTwoCard(point, this.logic);
            deck.add(m);
            point = point + 10;
        }

        // MOVE_THREE Cards
        point = 790;
        for (int i = 1; i <= 6; i++) {
            MoveThreeCard m = new MoveThreeCard(point, this.logic);
            deck.add(m);
            point = point + 10;
        }
    }

    /**
     * Shuffles the deck. Use this before getting cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Adds a card back to the deck.
     *
     * @param card A single card to be added back to the deck.
     */
    public void addCard(Card card) {
        deck.add(card);
    }

    /*
    Getters
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Return the desired amount of cards and then removes them from the deck.
     * This happens to prevent retrieving doubles of the same card.
     *
     * @param amount The desired amount of cards.
     * @return The amount of cards.
     */
    public ArrayList<Card> getCards(int amount) {
        ArrayList<Card> tempDeck = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tempDeck.add(deck.get(i));
            deck.remove(i);
        }
        return tempDeck;
    }
}
