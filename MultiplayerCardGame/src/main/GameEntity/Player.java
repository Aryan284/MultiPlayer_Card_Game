package main.GameEntity;

import java.util.ArrayList;

public class Player {
    private int id;
    private ArrayList<GameEntity.Card> deckCards = new ArrayList<>();
    public Player(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public ArrayList<GameEntity.Card> getCard(){
        return deckCards;
    }

    public void addCards(GameEntity.Card card){
        deckCards.add(card);

    }
    public String toString(){
        return id + " " + deckCards.toString();

    }
}
