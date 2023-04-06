package GameEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deckOfCard;
    public Deck(){
        deckOfCard = new ArrayList<>();
        for(Suits suit: Suits.values()){
            for(int i = 1; i <= 13; i++){
                deckOfCard.add(new Card(i, suit));

            }
        }
        Collections.shuffle(deckOfCard);
    }
    public ArrayList<Card> getDeckOfCard(){
        return deckOfCard;

    }


}
