package robogp.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.util.Pair;

public class PersonalPool implements Observer, Serializable {

    private List<Card> istruzioni;

    public PersonalPool() {
        this.istruzioni = new ArrayList<>();
    }

    /*
     * k true se aggiungiamo carta a istruzioni, false altrimenti. 
     */
    @Override
    public void update(Observable o, Object arg) {
        boolean k = (boolean) ((Pair) arg).getKey();
        Card card = (Card) ((Pair) arg).getValue();

        if (k) {
            this.istruzioni.add(card);
        } else {
            this.istruzioni.remove(card);
        }
    }

    public List<Card> getIstruzioni() {
        return istruzioni;
    }
    
  

}
